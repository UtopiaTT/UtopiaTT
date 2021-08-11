package com.bw.kongchenliang.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.kongchenliang.R;
import com.bw.kongchenliang.adapter.FoodAdapter;
import com.bw.kongchenliang.bean.FoodBean;
import com.bw.kongchenliang.contract.MyContract;
import com.bw.kongchenliang.model.FoodModel;
import com.bw.kongchenliang.presenter.FoodPresenter;
import com.bw.mvp.view.BaseActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity<FoodPresenter> implements MyContract.mView {


    private SmartRefreshLayout smart;
    private RecyclerView rv;
    List<FoodBean.DataBean> data;
    int index=1;
    private android.widget.ImageView shop;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }
    @Override
    public int foodPage() {
        return index;
    }

    @Override
    public void showFood(FoodBean foodBean) {

        data = foodBean.getData();

        FoodAdapter foodAdapter = new FoodAdapter(R.layout.item_rv, data);
        rv.setAdapter(foodAdapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        smart.finishRefresh();
        smart.finishLoadMore();
        smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                index++;
                if (index>=10){
                    index=1;
                }
                presenter.getFood();
            }

            @Override
            public void onRefresh( RefreshLayout refreshLayout) {
                index=new Random().nextInt(10);
                if (index==0){
                    index=1;
                }
                presenter.getFood();
            }
        });

        foodAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this,FoodActivity.class);
                intent.putExtra("img",data.get(position).getPic());
                intent.putExtra("title",data.get(position).getTitle());
                intent.putExtra("price",data.get(position).getNum());
                intent.putExtra("type",data.get(position).getFood_str());
                startActivity(intent);
            }
        });
    }


    @Override
    public void initView() {

        smart = (SmartRefreshLayout) findViewById(R.id.smart);
        rv = (RecyclerView) findViewById(R.id.rv);
        shop = (ImageView) findViewById(R.id.shop);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        presenter=new FoodPresenter(new FoodModel(),this);
        presenter.getFood();
    }

    @Override
    public void showIcon() {

    }

    @Override
    public void hideIcon() {

    }
}