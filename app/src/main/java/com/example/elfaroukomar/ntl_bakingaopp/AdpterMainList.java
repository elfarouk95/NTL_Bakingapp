package com.example.elfaroukomar.ntl_bakingaopp;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elfaroukomar.ntl_bakingaopp.Models.Bakmodel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Elfarouk Omar on 16/10/2017.
 */

public class AdpterMainList extends RecyclerView.Adapter<AdpterMainList.VH>  {

    private Context context;
    private ArrayList<Bakmodel>bakmodels;

    public AdpterMainList (Context c , ArrayList<Bakmodel>bakmodel)
    {
        context=c;
        bakmodels=bakmodel;

    }

    @Override
    public VH  onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.mainitem,parent,false);
        VH vh = new VH(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        holder.maintext.setText(bakmodels.get(position).getName());
        holder.subText.setText("Servings:"+bakmodels.get(position).getServings());
        if (!bakmodels.get(position).getImage().equals(""))
        {
            Picasso.with(context).load(bakmodels.get(position).getImage()).into(holder.imageView);
        }
    }


    @Override
    public int getItemCount() {
        return bakmodels.size();
    }

    class VH extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView maintext;
        TextView subText;
        ImageView imageView;
        public VH(View itemView) {
            super(itemView);
            maintext=(TextView)itemView.findViewById(R.id.mainName);
            subText=(TextView)itemView.findViewById(R.id.subtext);
            imageView=(ImageView)itemView.findViewById(R.id.imageview);
            itemView.setOnClickListener(this);
        }
        void update(String s)
        {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.baking_widget);
            ComponentName thisWidget = new ComponentName(context,BakingWidget.class);
            remoteViews.setTextViewText(R.id.appwidget_text, s);
            appWidgetManager.updateAppWidget(thisWidget, remoteViews);
        }

        @Override
        public void onClick(View view) {
            Intent n = new Intent(context,DetailsActivty.class);
            n.putExtra("Listitem",bakmodels.get(getAdapterPosition()));
            context.startActivity(n);

        }
    }
}
