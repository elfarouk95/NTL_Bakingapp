package com.example.elfaroukomar.ntl_bakingaopp.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Elfarouk Omar on 16/10/2017.
 */

public class Bakmodel implements Serializable {
    String id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredients_Model> getIngredients_models() {
        return ingredients_models;
    }

    public void setIngredients_models(ArrayList<Ingredients_Model> ingredients_models) {
        this.ingredients_models = ingredients_models;
    }

    public ArrayList<Steps_Model> getSteps_models() {
        return steps_models;
    }

    public void setSteps_models(ArrayList<Steps_Model> steps_models) {
        this.steps_models = steps_models;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    String name;
    ArrayList<Ingredients_Model>ingredients_models;
    ArrayList<Steps_Model>steps_models;
    String servings;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String image;

}
