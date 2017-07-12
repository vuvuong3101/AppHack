package com.example.rufflez.Cookbook.model;

import java.util.ArrayList;

/**
 * Created by HoangLong on 6/27/2017.
 */

public class FoodTypeDataModel {
    private String headerTitle;
    private ArrayList<ItemInTypeFoodModel> allItemsInSection;


    public FoodTypeDataModel() {

    }
    public FoodTypeDataModel(String headerTitle, ArrayList<ItemInTypeFoodModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<ItemInTypeFoodModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<ItemInTypeFoodModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

}
