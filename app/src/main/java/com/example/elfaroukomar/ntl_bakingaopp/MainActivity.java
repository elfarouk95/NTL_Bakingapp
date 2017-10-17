package com.example.elfaroukomar.ntl_bakingaopp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.elfaroukomar.ntl_bakingaopp.JsonParse.Parse;
import com.example.elfaroukomar.ntl_bakingaopp.Models.Bakmodel;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    RecyclerView recyclerView;
    AdpterMainList adpterMainList;
    String url ="https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView)findViewById(R.id.Rvrecap);

        request(this);

    }

    GridLayoutManager gridLayoutManager;
    void request(final Context context)
    {
        StringRequest strReq = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    ArrayList<Bakmodel> bakmodels =Parse.Pare(response);
                    adpterMainList = new AdpterMainList(context,bakmodels);
                     gridLayoutManager= new GridLayoutManager(getApplicationContext(),1);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(adpterMainList);


                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(strReq);

    }

    ArrayList<String> Con(ArrayList<Bakmodel>bakmodels)
    {
        ArrayList<String>strings = new ArrayList<>();
        for (int i=0;i<bakmodels.size();i++)
        {
            strings.add(bakmodels.get(i).getName());

        }
        return strings;
    }
}
