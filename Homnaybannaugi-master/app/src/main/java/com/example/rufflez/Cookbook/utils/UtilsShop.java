package com.example.rufflez.Cookbook.utils;

import com.example.rufflez.Cookbook.databases.FoodModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac-vuongvu on 7/8/17.
 */

public class UtilsShop {
    public static List<FoodModel> loclist (List<FoodModel> foodModelList, boolean shopping){
        List<FoodModel> foodModels = new ArrayList<>();
        for (FoodModel foodModel: foodModelList) {
            if (foodModel.isNguyenLieuDaChon() == shopping) {
                foodModels.add(foodModel);
            }
        }

        return foodModels;
    }
}
