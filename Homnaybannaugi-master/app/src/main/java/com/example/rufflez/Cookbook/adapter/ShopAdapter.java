package com.example.rufflez.Cookbook.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.databases.DatabaseHandle;
import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.Cookbook.dialog.DialogFragment;
import com.example.rufflez.myapplication.R;

import java.util.List;

import static com.example.rufflez.myapplication.R.id.sho_title_header;
import static github.chenupt.multiplemodel.aa.AAModelFactory.TAG;

/**
 * Created by HoangLong on 7/8/2017.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private Context context;
    private List<FoodModel> singleItemModelList;
    private FoodModel foodModel;
    String i[];

    public ShopAdapter(Context context, List<FoodModel> foodModelList) {
        this.context = context;
        this.singleItemModelList = foodModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_shop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final FoodModel singleItemModel = singleItemModelList.get(position);
        holder.foodtile.setText(singleItemModel.getTitleFood());

        i = singleItemModel.getIngredientFood().split("-");
//        ArrayAdapter adapter = new ArrayAdapter(context,android.R.layout.simple_list_item_multiple_choice,i);
//        holder.listView.setAdapter(adapter);

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder.recyclerView.getContext()));
        holder.recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(context, i));
        holder.ivCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.FragmentManager manager = ((Activity) context).getFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putSerializable("data",singleItemModel);
                DialogFragment dialogFragment = new DialogFragment();
                dialogFragment.show(manager,"Simple fm");
                dialogFragment.setArguments(bundle);
            }
        });
        holder.ivDelITem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(singleItemModel.isNguyenLieuDaChon()){
//                    singleItemModel.setNguyenLieuDaChon(false);
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Bạn muốn xóa tất món này không ?");
                    builder.setCancelable(true);
                    builder.setNegativeButton("Không!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.setPositiveButton("Vâng", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseHandle.getHandle(context).setShopping(false,singleItemModel);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                Log.d(TAG, "onClick: Sao k xóa :3");
            }
        });
        Log.d(TAG, "onBindViewHolder: " + i);
    }

    @Override
    public int getItemCount() {
        return singleItemModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView foodtile;
        //ListView listView;
        ImageView ivCook;
        ImageView ivDelITem;
        RecyclerView recyclerView;
        public ViewHolder(View itemView) {
            super(itemView);
            foodtile =  (TextView) itemView.findViewById(sho_title_header);
            //listView = itemView.findViewById(R.id.lv_nguyen_lieu);
            recyclerView = itemView.findViewById(R.id.lv_nguyen_lieu);
            ivCook = itemView.findViewById(R.id.btn_cook);
            ivDelITem = itemView.findViewById(R.id.btn_del_item_cook);
        }
    }

    public static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {
        private String[] mValues;
        private Context mContext;
        private boolean isBuy;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public final View mView;
            public final TextView mTextView;
            CheckBox checkBox;
            private boolean isBuy;


            public ViewHolder(View view) {
                super(view);
                mView = view;
                mTextView = (TextView) view.findViewById(android.R.id.text1);
                checkBox = view.findViewById(R.id.cb_shop);
            }

        }

        public String getValueAt(int position) {
            return mValues[position];
        }

        public SimpleStringRecyclerViewAdapter(Context context, String[] items) {
            mContext = context;
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_nguyen_lieu_in_shop, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mTextView.setText(mValues[position]);
            holder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isBuy){
                        holder.mTextView.setPaintFlags(holder.mTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        holder.mTextView.setTextColor(Color.GRAY);
                        holder.checkBox.setChecked(true);
                        isBuy = false;
                    }else{
                        holder.mTextView.setPaintFlags(0);
                        holder.mTextView.setTextColor(Color.GRAY);
                        holder.checkBox.setChecked(false);
                        isBuy = true;
                    }
                }
            });
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isBuy){
                        holder.mTextView.setPaintFlags(holder.mTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        holder.mTextView.setTextColor(Color.GRAY);
                        holder.checkBox.setChecked(true);
                        isBuy = false;
                    }else{
                        holder.mTextView.setPaintFlags(0);
                        holder.mTextView.setTextColor(Color.GRAY);
                        holder.checkBox.setChecked(false);
                        isBuy = true;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.length;
        }
    }



}
