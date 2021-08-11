package com.bw.kongchenliang.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.kongchenliang.R;
import com.bw.kongchenliang.bean.FoodBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class FoodAdapter extends BaseQuickAdapter<FoodBean.DataBean, BaseViewHolder> {
    public FoodAdapter(int layoutResId, List<FoodBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodBean.DataBean item) {
        Glide.with(mContext).load(item.getPic()).into((ImageView) helper.getView(R.id.tv_img));
        helper.setText(R.id.tv_title,item.getTitle());
        int num = item.getNum();
        float arr=num;
        helper.setText(R.id.tv_price,arr+"");
    }
}
