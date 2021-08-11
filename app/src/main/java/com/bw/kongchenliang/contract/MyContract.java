package com.bw.kongchenliang.contract;

import com.bw.kongchenliang.bean.FoodBean;
import com.bw.mvp.model.IModel;
import com.bw.mvp.view.IView;

import io.reactivex.Observer;

public interface MyContract {
    interface mModel extends IModel{
        void reqFood(Integer stage_id, Integer limit, Integer page, Observer<FoodBean> observer);
    }
    interface mView extends IView{
        int foodPage();
        void showFood(FoodBean foodBean);
    }
}
