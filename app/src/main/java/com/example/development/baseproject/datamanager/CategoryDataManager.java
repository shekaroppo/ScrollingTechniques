package com.example.development.baseproject.datamanager;

import com.example.development.baseproject.model.ExampleModel;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Sekhar on 4/6/15.
 */
public class CategoryDataManager {
    public static final String ENDPOINT = "http://api-v2.hearthis.at";
    private static final RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(ENDPOINT)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();
    private static final CategoryAPI mCategoryApiService = restAdapter.create(CategoryAPI.class);

    public static Observable<List<ExampleModel>> getCategorys() {
        return mCategoryApiService.getCategorys();
    }

    public interface CategoryAPI {
        @GET("/categories/")
        Observable<List<ExampleModel>> getCategorys();
    }
}
