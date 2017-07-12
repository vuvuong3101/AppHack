package com.example.rufflez.Cookbook.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.DetailFoodActivity;
import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.myapplication.R;

import java.util.List;

/**
 * Created by HoangLong on 7/1/2017.
 */

public class MoreFoodGridAdapter extends BaseAdapter {

    private Context mContext;
    private List<FoodModel>foodModelList;
    private String typeFood;
    private CardView cardView;

    public MoreFoodGridAdapter(Context mContext, List<FoodModel> foodModelList) {
        this.mContext = mContext;
        this.foodModelList = foodModelList;
        this.typeFood = typeFood;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return  foodModelList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        FoodModel foodModel = foodModelList.get(position);
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.more_item_in_type_food_grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.tv_name_food);
            ImageView imageView = (ImageView)grid.findViewById(R.id.img_more_food);
            TextView tvTime = (TextView) grid.findViewById(R.id.item_time);
            tvTime.setText(foodModel.getThoiGianNau());
            textView.setText(foodModel.getTitleFood());
            String image[] =  foodModel.getAvatarFood().split(",");
            byte[] decodebyte = Base64.decode(image[1], Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
            imageView.setImageBitmap(bitmap);
            cardView =  grid.findViewById(R.id.cv_more_food);
            final FoodModel singleItemModel = foodModelList.get(position);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailFoodActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("singleItemModel", singleItemModel);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            });

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
