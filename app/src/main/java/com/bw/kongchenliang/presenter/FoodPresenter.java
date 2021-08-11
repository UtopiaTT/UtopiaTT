package com.bw.kongchenliang.presenter;

import com.bw.kongchenliang.bean.FoodBean;
import com.bw.kongchenliang.contract.MyContract;
import com.bw.mvp.presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FoodPresenter extends BasePresenter<MyContract.mModel,MyContract.mView>{
    private Disposable disposable;
    public FoodPresenter(MyContract.mModel model, MyContract.mView view) {
        super(model, view);
    }
    public void getFood(){
        model.reqFood(1, 20, view.foodPage(), new Observer<FoodBean>() {
            @Override
            public void onSubscribe( Disposable d) {

            }

            @Override
            public void onNext( FoodBean foodBean) {
                view.showFood(foodBean);
            }

            @Override
            public void onError( Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void destory() {
        super.destory();
        if (disposable.isDisposed()){
            disposable.dispose();
        }
    }
}
