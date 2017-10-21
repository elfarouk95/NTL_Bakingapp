package com.example.elfaroukomar.ntl_bakingaopp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.elfaroukomar.ntl_bakingaopp.Models.Steps_Model;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.squareup.picasso.Picasso;

import java.net.URI;


public class Step extends Fragment  implements ExoPlayer.EventListener{

    Steps_Model steps_model;
    Context context;
    public Step() {

        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("item1",steps_model);
        outState.putLong("vpos",vPos);
    }

    public Step(Context c, Steps_Model s) {

        context=c;
        steps_model=s;
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            steps_model= (Steps_Model) savedInstanceState.getSerializable("item1");
            vPos=savedInstanceState.getLong("vpos");
        }
    }

    SimpleExoPlayerView videoView;
    SimpleExoPlayer simpleExoPlayer;
    ImageView imageView;
    long vPos;

    private void initializePlayer(Uri mediaUri) {
        if (simpleExoPlayer == null) {
            // Create an instance of the ExoPlayer.
            TrackSelector trackSelector = new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();
            simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(getActivity().getApplicationContext(), trackSelector, loadControl);
            videoView.setPlayer(simpleExoPlayer);

            // Set the ExoPlayer.EventListener to this activity.
            simpleExoPlayer.addListener(this);

            // Prepare the MediaSource.
            String userAgent = Util.getUserAgent(getActivity().getApplicationContext(), "ClassicalMusicQuiz");
            MediaSource mediaSource = new ExtractorMediaSource(mediaUri, new DefaultDataSourceFactory(getActivity().getApplicationContext(), userAgent), new DefaultExtractorsFactory(), null, null);
            simpleExoPlayer.prepare(mediaSource);
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (simpleExoPlayer!=null) {
            Toast.makeText(getActivity().getApplication().getApplicationContext(), "here", Toast.LENGTH_SHORT).show();
            simpleExoPlayer.release();
            simpleExoPlayer.stop();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_step, container, false);

        videoView =(SimpleExoPlayerView) v.findViewById(R.id.videoView);
        imageView =(ImageView)v.findViewById(R.id.imageview);
        if (!steps_model.getVideoURL().equals("")){
            Uri uri =Uri.parse(steps_model.getVideoURL());
            initializePlayer(uri);
            simpleExoPlayer.seekTo(vPos);
            imageView.setVisibility(View.INVISIBLE);
            videoView.setVisibility(View.VISIBLE);
        }
        else if (!steps_model.getThumbnailURL().equals(""))
        {
            videoView.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
            Picasso.with(getActivity().getApplicationContext()).load(steps_model.getThumbnailURL()).into(imageView);
        }
        else {
            videoView.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
        }


        ((TextView)v.findViewById(R.id.textviewdes)).setText(steps_model.getDescription());
        return v;
    }

    @Override
    public void onTimelineChanged(Timeline timeline, Object o) {

    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {

    }

    @Override
    public void onLoadingChanged(boolean b) {

    }

    @Override
    public void onPlayerStateChanged(boolean b, int i) {


        if((i == ExoPlayer.STATE_READY) && b){
            vPos=simpleExoPlayer.getCurrentPosition();

        } else if((i == ExoPlayer.STATE_READY)){


        }
    }

    @Override
    public void onPlayerError(ExoPlaybackException e) {

    }

    @Override
    public void onPositionDiscontinuity() {

    }
}
