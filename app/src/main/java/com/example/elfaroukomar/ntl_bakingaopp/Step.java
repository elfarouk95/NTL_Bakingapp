package com.example.elfaroukomar.ntl_bakingaopp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.elfaroukomar.ntl_bakingaopp.Models.Steps_Model;


public class Step extends Fragment {

    Steps_Model steps_model;
    Context context;
    public Step() {

        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("item1",steps_model);
    }

    public Step(Context c, Steps_Model s) {

        context=c;
        steps_model=s;
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null)steps_model= (Steps_Model) savedInstanceState.getSerializable("item1");
    }

    VideoView videoView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_step, container, false);

        videoView =(VideoView)v.findViewById(R.id.videoView);
        if (!steps_model.getVideoURL().equals("")){
        videoView.setVideoPath(steps_model.getVideoURL());
        videoView.start();
        }


        ((TextView)v.findViewById(R.id.textviewdes)).setText(steps_model.getDescription());
        return v;
    }
}
