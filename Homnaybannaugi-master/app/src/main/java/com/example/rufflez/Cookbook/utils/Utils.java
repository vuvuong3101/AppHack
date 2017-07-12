package com.example.rufflez.Cookbook.utils;

import com.example.rufflez.Cookbook.databases.FoodModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac-vuongvu on 7/8/17.
 */

public class Utils {
    public static List<FoodModel> loclist (List<FoodModel> foodModelList, String foodFilter){
        List<FoodModel> foodModels = new ArrayList<>();
        for (FoodModel foodModel: foodModelList) {
            if (foodModel.getTypeFood().equals(foodFilter)) {
                foodModels.add(foodModel);
            }
        }

        return foodModels;
    }
}
