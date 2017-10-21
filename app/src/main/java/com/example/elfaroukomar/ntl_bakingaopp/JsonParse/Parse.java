package com.example.elfaroukomar.ntl_bakingaopp.JsonParse;

import com.example.elfaroukomar.ntl_bakingaopp.Models.Bakmodel;
import com.example.elfaroukomar.ntl_bakingaopp.Models.Ingredients_Model;
import com.example.elfaroukomar.ntl_bakingaopp.Models.Steps_Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Elfarouk Omar on 16/10/2017.
 */

public class Parse {

 public  static    ArrayList<Bakmodel> Pare(String Json) throws JSONException {
     ArrayList<Bakmodel>bakmodels = new ArrayList<>();

     JSONArray jsonArray = new JSONArray(Json);
     for (int i =0;i<jsonArray.length();i++)
     {
         JSONObject jsonObject =jsonArray.getJSONObject(i);
         Bakmodel bakmodel =new Bakmodel();
         bakmodel.setId(jsonObject.getString("id"));
         bakmodel.setName(jsonObject.getString("name"));
         bakmodel.setServings(jsonObject.getString("servings"));

         ArrayList<Ingredients_Model>ingredients_models = new ArrayList<>();

         JSONArray ingred =jsonObject.getJSONArray("ingredients");
         for (int j =0; j<ingred.length();j++)
         {
             JSONObject jOb = ingred.getJSONObject(j);
             Ingredients_Model ingredients_model = new Ingredients_Model();
             ingredients_model.setQuantity(jOb.getString("quantity"));
             ingredients_model.setMeasure(jOb.getString("measure"));
             ingredients_model.setIngredient(jOb.getString("ingredient"));
             ingredients_models.add(ingredients_model);

         }
         bakmodel.setIngredients_models(ingredients_models);



         ArrayList<Steps_Model>steps_models = new ArrayList<>();
         JSONArray step =jsonObject.getJSONArray("steps");
         for (int j =0; j<step.length();j++)
         {
             JSONObject jOb = step.getJSONObject(j);
             Steps_Model steps_model = new Steps_Model();
             steps_model.setId(jOb.getString("id"));
             steps_model.setShortDescription(jOb.getString("shortDescription"));
             steps_model.setDescription(jOb.getString("description"));
             steps_model.setVideoURL(jOb.getString("videoURL"));
             steps_model.setThumbnailURL(jOb.getString("thumbnailURL"));

             steps_models.add(steps_model);


         }

          bakmodel.setSteps_models(steps_models);
         bakmodel.setImage(jsonObject.getString("image"));
         bakmodels.add(bakmodel);

     }


  return bakmodels;
 }
}
