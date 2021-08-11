package com.bw.kongchenliang.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bw.kongchenliang.R;
import com.bw.kongchenliang.bean.FoodEntitiy;
import com.bw.kongchenliang.db.FoodEntitiyDao;
import com.bw.kongchenliang.utils.SqlUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    private Banner banner;
    private TextView price;
    private TextView title;
    private TextView type;
    private ImageView shop;
    private LinearLayout goumai;
    private TextView pay;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        initView();
        Intent intent = getIntent();
        String imgs = intent.getStringExtra("img");
        String titles = intent.getStringExtra("title");
        String types = intent.getStringExtra("type");
        int prices = intent.getIntExtra("price", 0);
        float arr = prices;
        title.setText(titles);
        price.setText(arr + "");
        type.setText(types);
        pay.setText(prices+"");
        ArrayList<String> list = new ArrayList<>();
        list.add(imgs);
        list.add(imgs);
        list.add(imgs);
        list.add(imgs);
        banner.setDelayTime(2000);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImages(list);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.start();

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });
        goumai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 储存SP
                 */
                SharedPreferences sp = getSharedPreferences("kcl", MODE_PRIVATE);
                edit = sp.edit();
                SqlUtils sqlUtils = new SqlUtils();
                FoodEntitiyDao foodDao = sqlUtils.sqlutil(FoodActivity.this).getFoodEntitiyDao();
                FoodEntitiy foodEntitiy = new FoodEntitiy();
                foodEntitiy.setImg(imgs);
                foodEntitiy.setPrice(prices);
                foodEntitiy.setTitle(titles);
                foodDao.insert(foodEntitiy);
                edit.commit();
                Toast.makeText(FoodActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * Sp清除
         */
        edit.clear();
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        price = (TextView) findViewById(R.id.price);
        title = (TextView) findViewById(R.id.title);
        type = (TextView) findViewById(R.id.type);
        shop = (ImageView) findViewById(R.id.shop);
        goumai = (LinearLayout) findViewById(R.id.goumai);
        pay = (TextView) findViewById(R.id.pay);
    }
}