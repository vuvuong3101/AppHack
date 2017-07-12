package com.example.rufflez.Cookbook.utils;


import com.example.rufflez.Cookbook.databases.FoodModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac-vuongvu on 7/10/17.
 */

public class UtilsFilter {
    public static List<FoodModel> loclist (List<FoodModel> foodModelList, String foodFilter, String foodDisplay){
        List<FoodModel> foodModels = new ArrayList<>();
        for (FoodModel foodModel: foodModelList) {
            if (foodModel.getTypeFood().equals(foodFilter)) {
                if (foodModel.getDisplayHome().equals(foodDisplay)) {
                    foodModels.add(foodModel);

                }
            }
        }

        return foodModels;
    }
}
