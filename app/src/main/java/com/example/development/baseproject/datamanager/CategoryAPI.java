package com.example.development.baseproject.datamanager;

import com.example.development.baseproject.model.ExampleModel;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface CategoryAPI {
    @GET("/categories/")
    Observable<List<ExampleModel>> getCategorys();
}