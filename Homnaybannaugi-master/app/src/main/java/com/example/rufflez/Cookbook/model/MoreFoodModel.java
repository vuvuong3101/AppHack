package com.example.rufflez.Cookbook.model;

/**
 * Created by HoangLong on 7/1/2017.
 */

public class MoreFoodModel {
    private String name;
    private int url;

    public MoreFoodModel(String name, int url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }
}
