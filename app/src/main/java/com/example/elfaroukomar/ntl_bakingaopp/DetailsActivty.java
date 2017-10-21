package com.example.elfaroukomar.ntl_bakingaopp;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.elfaroukomar.ntl_bakingaopp.Models.Bakmodel;

public class DetailsActivty extends AppCompatActivity  {

    private ingandsteplistfragment.StepClickListener stepClickListener;
    boolean IsTab;
    ingandsteplistfragment ILF;
    Step step;


    void update(String s)
    {
        Context context = this;
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.baking_widget);
        ComponentName thisWidget = new ComponentName(context,BakingWidget.class);
        remoteViews.setTextViewText(R.id.appwidget_text, s);
        appWidgetManager.updateAppWidget(thisWidget, remoteViews);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activty);


        Intent n = getIntent();
        final Bakmodel bak = (Bakmodel) n.getSerializableExtra("Listitem");
        Toast.makeText(this, bak.getName(), Toast.LENGTH_SHORT).show();
        setTitle(bak.getName());
        ILF =new ingandsteplistfragment(this,bak);
               update(ingandsteplistfragment.Convert(bak.getIngredients_models()));
        IsTab=getResources().getBoolean(R.bool.istablet);
       if (!IsTab)
        getSupportFragmentManager().beginTransaction().replace(R.id.conti,ILF).commit();
        else    getSupportFragmentManager().beginTransaction().replace(R.id.Left,ILF).commit();

        stepClickListener =new ingandsteplistfragment.StepClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                 if(!IsTab){
                Toast.makeText(view.getContext(), ""+position, Toast.LENGTH_SHORT).show();

                Intent n = new Intent(DetailsActivty.this,StepsActivity.class);
                n.putExtra("numsteps",String.valueOf(bak.getSteps_models().size()));
                n.putExtra("List",bak.getSteps_models());
                n.putExtra("pos",String.valueOf(position));
                startActivity(n);}
                else {
                     step=new Step(getApplicationContext(),bak.getSteps_models().get(position));
                     getSupportFragmentManager().beginTransaction().replace(R.id.Right,step).commit();


                 }




            }
        };

        ILF.SetClickListener2(stepClickListener);

      }





}

