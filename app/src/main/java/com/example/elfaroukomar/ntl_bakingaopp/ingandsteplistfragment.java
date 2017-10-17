package com.example.elfaroukomar.ntl_bakingaopp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elfaroukomar.ntl_bakingaopp.Models.Bakmodel;
import com.example.elfaroukomar.ntl_bakingaopp.Models.Ingredients_Model;

import java.util.ArrayList;


public class ingandsteplistfragment extends Fragment implements RvStepAdpter.ItemClickListener {


    Context context;
    Bakmodel bakmodel;
    private StepClickListener stepClickListener;
    public ingandsteplistfragment() {
        // Required empty public constructor
    }

    public ingandsteplistfragment(Context c, Bakmodel b) {

        context=c;
        bakmodel=b;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("item",bakmodel);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null)bakmodel= (Bakmodel) savedInstanceState.getSerializable("item");
    }

    TextView mingredients;

    private String Convert(ArrayList<Ingredients_Model>ingredients_models)
    {
        String ing ="Ingredients List \n";
          String qty="";
        String mes="";
        String description="";
        for (int i=0;i<ingredients_models.size();i++)
        {

            description=ingredients_models.get(i).getIngredient() ;
            qty =ingredients_models.get(i).getQuantity();
            mes=ingredients_models.get(i).getMeasure();

            ing+="* "+description+"( "+qty+" "+mes+" )\n";
        }

         return ing;
    }
    RecyclerView rvstep;
    RvStepAdpter rvStepAdpter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ingandsteplistfragment, container, false);
        mingredients=(TextView)v.findViewById(R.id.ingredients);
        mingredients.setText(Convert(bakmodel.getIngredients_models()));
        rvstep =(RecyclerView)v.findViewById(R.id.RVSteps);
        rvStepAdpter = new RvStepAdpter(context,bakmodel.getSteps_models());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rvstep.setLayoutManager(linearLayoutManager);
        rvstep.setAdapter(rvStepAdpter);

       rvStepAdpter.setClickListener2(this);




        return v;
    }


    @Override
    public void onItemClick(View view, int position) {
       // Toast.makeText(context, "Sdsd2", Toast.LENGTH_SHORT).show();
        if (stepClickListener != null) stepClickListener.onItemClick(view, position);
    }
     /*
     * public void setClickListener2(ItemClickListener itemClickListener) {
        this.mClickListener =  itemClickListener;
    }*/
   public  void  SetClickListener2(ingandsteplistfragment.StepClickListener itemClickListener)
   {
       this.stepClickListener=itemClickListener;
   }

    public interface StepClickListener {
        void onItemClick(View view, int position);
    }
}
