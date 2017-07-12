package com.example.rufflez.Cookbook.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.DetailFoodActivity;
import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.myapplication.R;

import java.util.List;

import static com.example.rufflez.myapplication.R.id.tvTitle;

/**
 * Created by HoangLong on 7/8/2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private Context context;
    private List<FoodModel> singleItemModelList;

    public FoodAdapter(Context context, List<FoodModel> foodModelList) {
        this.context = context;
        this.singleItemModelList = foodModelList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_in_type_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FoodModel singleItemModel = singleItemModelList.get(position);

        String image[] =  singleItemModel.getAvatarFood().split(",");
        byte[] decodebyte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
        holder.foodimage.setImageBitmap(bitmap);
        holder.time.setText(singleItemModel.getThoiGianNau() + "p");
        holder.foodtile.setText(singleItemModel.getTitleFood());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailFoodActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("singleItemModel", singleItemModel);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return singleItemModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView foodtile,time;
        ImageView foodimage;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            foodimage = (ImageView) itemView.findViewById(R.id.itemImage);
            foodtile =  (TextView) itemView.findViewById(tvTitle);
            cardView = itemView.findViewById(R.id.card_view);
            time = (TextView) itemView.findViewById(R.id.item_time);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(context,DetailFoodActivity.class);
//                    context.startActivity(intent);
//                }
//            });


        }
    }
}
