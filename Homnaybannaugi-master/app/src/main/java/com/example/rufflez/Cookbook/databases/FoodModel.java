package com.example.rufflez.Cookbook.databases;

import java.io.Serializable;

public class FoodModel implements Serializable {
    private int id;
    private String typeFood;
    private String avatarFood;
    private String titleFood;
    private String ingredientFood;
    private String methodFood;
    private String khauPhan;
    private String calo;
    private String soNguyenLieu;
    private String thoiGianNau;
    private String displayHome;
    private boolean bookmark;
    private boolean nguyenLieuDaChon;
    private  boolean isShopping;

    public FoodModel(int id, String typeFood,
                     String avatarFood, String titleFood,
                     String ingredientFood, String methodFood,
                     String khauPhan, String calo,
                     String soNguyenLieu, String thoiGianNau,
                     String displayHome, boolean bookmark,
                     boolean nguyenLieuDaChon) {
        this.id = id;
        this.typeFood = typeFood;
        this.avatarFood = avatarFood;
        this.titleFood = titleFood;
        this.ingredientFood = ingredientFood;
        this.methodFood = methodFood;
        this.khauPhan = khauPhan;
        this.calo = calo;
        this.soNguyenLieu = soNguyenLieu;
        this.thoiGianNau = thoiGianNau;
        this.displayHome = displayHome;
        this.bookmark = bookmark;
        this.nguyenLieuDaChon = nguyenLieuDaChon;
    }



    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }

    public String getAvatarFood() {
        return avatarFood;
    }

    public void setAvatarFood(String avatarFood) {
        this.avatarFood = avatarFood;
    }

    public String getTitleFood() {
        return titleFood;
    }

    public void setTitleFood(String titleFood) {
        this.titleFood = titleFood;
    }

    public String getIngredientFood() {
        return ingredientFood;
    }

    public void setIngredientFood(String ingredientFood) {
        this.ingredientFood = ingredientFood;
    }

    public String getMethodFood() {
        return methodFood;
    }

    public void setMethodFood(String methodFood) {
        this.methodFood = methodFood;
    }

    public String getKhauPhan() {
        return khauPhan;
    }

    public void setKhauPhan(String khauPhan) {
        this.khauPhan = khauPhan;
    }

    public String getCalo() {
        return calo;
    }

    public void setCalo(String calo) {
        this.calo = calo;
    }

    public String getSoNguyenLieu() {
        return soNguyenLieu;
    }

    public void setSoNguyenLieu(String soNguyenLieu) {
        this.soNguyenLieu = soNguyenLieu;
    }

    public String getThoiGianNau() {
        return thoiGianNau;
    }

    public void setThoiGianNau(String thoiGianNau) {
        this.thoiGianNau = thoiGianNau;
    }

    public String getDisplayHome() {
        return displayHome;
    }

    public void setDisplayHome(String displayHome) {
        this.displayHome = displayHome;
    }

    public boolean isBookmark() {
        return bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNguyenLieuDaChon() {
        return nguyenLieuDaChon;
    }

    public void setNguyenLieuDaChon(boolean nguyenLieuDaChon) {
        this.nguyenLieuDaChon = nguyenLieuDaChon;
    }


    @Override
    public String toString() {
        return "FoodModel{" +
                "id=" + id +
                ", typeFood='" + typeFood + '\'' +
                ", avatarFood='" + avatarFood + '\'' +
                ", titleFood='" + titleFood + '\'' +
                ", ingredientFood='" + ingredientFood + '\'' +
                ", methodFood='" + methodFood + '\'' +
                ", khauPhan='" + khauPhan + '\'' +
                ", calo='" + calo + '\'' +
                ", soNguyenLieu='" + soNguyenLieu + '\'' +
                ", thoiGianNau='" + thoiGianNau + '\'' +
                ", displayHome='" + displayHome + '\'' +
                ", bookmark=" + bookmark +
                ", nguyenLieuDaChon='" + nguyenLieuDaChon + '\'' +
                ", isShopping=" + isShopping +
                '}';
    }
}
