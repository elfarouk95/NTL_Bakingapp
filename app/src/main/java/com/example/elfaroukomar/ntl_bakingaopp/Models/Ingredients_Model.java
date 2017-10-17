package com.example.elfaroukomar.ntl_bakingaopp.Models;

import java.io.Serializable;

/**
 * Created by Elfarouk Omar on 16/10/2017.
 */

public class Ingredients_Model implements Serializable {
    String quantity;
    String measure;
    String ingredient;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }




}
