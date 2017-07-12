package com.example.rufflez.Cookbook.utils;

import com.example.rufflez.Cookbook.databases.FoodModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac-vuongvu on 7/8/17.
 */

public class UtilsFav {
    public static List<FoodModel> loclist (List<FoodModel> foodModelList, boolean bookmark){
        List<FoodModel> foodModels = new ArrayList<>();
        for (FoodModel foodModel: foodModelList) {
            if (foodModel.isBookmark() == bookmark) {
                foodModels.add(foodModel);
            }
        }

        return foodModels;
    }
}
