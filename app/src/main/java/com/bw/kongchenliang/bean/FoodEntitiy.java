package com.bw.kongchenliang.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class FoodEntitiy {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private int price;
    private String img;
    private boolean ischeck=false;
    @Generated(hash = 1594459052)
    public FoodEntitiy(Long id, String title, int price, String img,
            boolean ischeck) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.img = img;
        this.ischeck = ischeck;
    }
    @Generated(hash = 1036881550)
    public FoodEntitiy() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public boolean getIscheck() {
        return this.ischeck;
    }
    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
}
