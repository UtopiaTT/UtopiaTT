package com.bw.kongchenliang.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bw.kongchenliang.R;
import com.bw.kongchenliang.bean.FoodBean;
import com.bw.kongchenliang.bean.FoodEntitiy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class FoodsAdapter extends BaseQuickAdapter<FoodEntitiy, BaseViewHolder> {

    public FoodsAdapter(int layoutResId, @Nullable  List<FoodEntitiy> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodEntitiy item) {
        Glide.with(mContext).load(item.getImg()).into((ImageView) helper.getView(R.id.img));
        helper.setText(R.id.title,item.getTitle());
        helper.setText(R.id.price,item.getPrice()+"");
        helper.setChecked(R.id.check,item.getIscheck());

        helper.addOnClickListener(R.id.check);
    }
}
