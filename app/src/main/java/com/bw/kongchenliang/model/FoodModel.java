package com.bw.kongchenliang.model;

import com.bw.kongchenliang.bean.FoodBean;
import com.bw.kongchenliang.contract.Api;
import com.bw.kongchenliang.contract.MyContract;
import com.bw.kongchenliang.utils.RetrofitUtils;
import com.bw.mvp.model.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class FoodModel extends BaseModel implements MyContract.mModel {
    @Override
    public void reqFood(Integer stage_id, Integer limit, Integer page, Observer<FoodBean> observer) {
        Retrofit retrofit = RetrofitUtils.getInstance().utils("http://www.qubaobei.com/");
        Api api = retrofit.create(Api.class);
        api.food(stage_id, limit, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
