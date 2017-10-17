package com.example.elfaroukomar.ntl_bakingaopp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elfaroukomar.ntl_bakingaopp.Models.Steps_Model;

import java.util.ArrayList;

/**
 * Created by Elfarouk Omar on 16/10/2017.
 */

public class RvStepAdpter extends RecyclerView.Adapter<RvStepAdpter.VH> {

    private Context context;
    private ArrayList<Steps_Model> steps_models;
    private ItemClickListener mClickListener;

    public RvStepAdpter(Context c , ArrayList<Steps_Model>s)
    {
        context=c;
        steps_models=s;

    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(context).inflate(R.layout.stepitem,parent,false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        String id =steps_models.get(position).getId();
        String description = steps_models.get(position).getShortDescription();

             holder.mStep.setText("   "+id+". "+description);
    }

    @Override
    public int getItemCount() {
        return steps_models.size();
    }

    class VH extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView mStep;
        public VH(View itemView) {
        super(itemView);
        mStep=(TextView)itemView.findViewById(R.id.Step);
        itemView.setOnClickListener(this);
    }

        @Override
        public void onClick(View view) {

            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public void setClickListener2(ItemClickListener itemClickListener) {
        this.mClickListener =  itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
