package com.example.rufflez.Cookbook.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac-vuongvu on 6/27/17.
 */

public class DatabaseHandle {
    private MyDatabase myDataBase;

    public DatabaseHandle(Context context) {
        myDataBase = new MyDatabase(context);
    }

    private static DatabaseHandle handle;

    public static DatabaseHandle getHandle(Context context) {
        if (handle == null) {
            handle = new DatabaseHandle(context);
        }
        return handle;
    }

    private SQLiteDatabase foodDataBase;

    public List<FoodModel> getListFood() {
        foodDataBase = myDataBase.getReadableDatabase();
        List<FoodModel> foodModelList = new ArrayList<>();
        Cursor cursor = foodDataBase.rawQuery("SELECT * FROM mainfoods",
                null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String typyFood = cursor.getString(1);
            String avatarFood = cursor.getString(2);
            String titleFood = cursor.getString(3);
            String ingredientFood = cursor.getString(4);
            String methodFood = cursor.getString(5);
            String khauPhan = cursor.getString(7);
            String calo = cursor.getString(8);
            String soNguyenLieu = cursor.getString(9);
            String thoiGianNau = cursor.getString(10);
            String displayHome = cursor.getString(11);
            boolean bookmark = cursor.getInt(6) != 0;
            boolean nguyenLieuDaChon = cursor.getInt(12) !=0;
            FoodModel foodModel = new FoodModel(id,typyFood, avatarFood,
                    titleFood, ingredientFood,
                    methodFood, khauPhan, calo,
                    soNguyenLieu, thoiGianNau, displayHome,
                    bookmark,nguyenLieuDaChon);
            foodModelList.add(foodModel);
            cursor.moveToNext();
        }
        return foodModelList;
    }

    public void setBookmark(boolean isBookmark, FoodModel foodModel) {
        foodDataBase = myDataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (isBookmark) {
            contentValues.put("book_mark", 1);
        } else {
            contentValues.put("book_mark", 0);
        }
        foodDataBase.update("mainfoods", contentValues, "id = " + foodModel.getId(), null);
    }
//
//    public void setUpdateNguyenLieu(FoodModel foodModel){
//        foodDataBase = myDataBase.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("nguyen_lieu_da_chon","co");
//        foodDataBase.update("mainfoods",contentValues,"id = " + foodModel.getId(),null);
//    }


    public  void setShopping(boolean isShopping, FoodModel foodModel) {
        foodDataBase = myDataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        if (isShopping) {
            contentValues.put("nguyen_lieu_da_chon", 1);
        } else {
            contentValues.put("nguyen_lieu_da_chon", 0);
        }
        foodDataBase.update("mainfoods", contentValues, "id = " + foodModel.getId(), null);

    }
}

