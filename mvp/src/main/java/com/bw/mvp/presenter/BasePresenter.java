package com.bw.mvp.presenter;

import com.bw.mvp.model.IModel;
import com.bw.mvp.view.IView;

public class BasePresenter<M extends IModel,V extends IView> implements IPresenter {
    protected M model;
    protected V view;

    public BasePresenter(M model, V view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void destory() {

    }
}
