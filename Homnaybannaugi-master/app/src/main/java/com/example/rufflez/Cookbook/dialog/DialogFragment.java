package com.example.rufflez.Cookbook.dialog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.myapplication.R;

/**
 * Created by HoangLong on 7/11/2017.
 */

public class DialogFragment extends android.app.DialogFragment {
    private TextView tvName,tvStep;
    private ImageView ivFood;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_step_food, container, false);
        FoodModel foodModel = (FoodModel) getArguments().getSerializable("data");
        getDialog().setTitle("abc");

        tvName = rootView.findViewById(R.id.name_food_dialog);
        tvStep = rootView.findViewById(R.id.content_cach_nau_dialog);
        ivFood = rootView.findViewById(R.id.image_food_dialog);
        tvName.setText(foodModel.getTitleFood());
        tvStep.setText(foodModel.getMethodFood());
        String image[] = foodModel.getAvatarFood().split(",");
        byte[] decodebyte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
        ivFood.setImageBitmap(bitmap);
        return rootView;
    }
}
