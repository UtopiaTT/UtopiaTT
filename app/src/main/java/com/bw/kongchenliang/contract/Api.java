package com.bw.kongchenliang.contract;

import com.bw.kongchenliang.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("ios/cf/dish_list.php")
    Observable<FoodBean> food(@Query("stage_id") Integer stage_id,@Query("limit") Integer limit,@Query("page") Integer page);
}
