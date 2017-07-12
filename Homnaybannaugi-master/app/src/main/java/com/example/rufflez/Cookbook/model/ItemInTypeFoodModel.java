package com.example.rufflez.Cookbook.model;

/**
 * Created by HoangLong on 6/27/2017.
 */

public class ItemInTypeFoodModel {


    private String name;
    private String url;
    private String description;


    public ItemInTypeFoodModel() {
    }

    public ItemInTypeFoodModel(String name, String url) {
        this.name = name;
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}