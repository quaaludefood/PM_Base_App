package com.example.PM_Base_App.data.remote.api;

import com.example.PM_Base_App.data.remote.model.ActionApiResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ActionApiService {

    @GET("actions")
    Observable<ActionApiResponse> fetchActions();
}
