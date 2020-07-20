package com.example.smartmart001.Controller;

import com.example.smartmart001.History.History;
import com.example.smartmart001.Store.Store;
import com.example.smartmart001.StoreItems.StoreItemsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StoreApi {

        @GET("/stores")
        Call<ArrayList<Store>> getStores();

        @GET("/stores/{sId}/items")
        Call<ArrayList<StoreItemsList>> getItems(@Path("sId") int id);

        @HTTP(method = "DELETE" , path = "/customers/{cid}/history")
        Call<Void> deleteHistory(@Path("cid") int cid);

        @POST("customers/{cid}/history")
        Call<Void> saveHistory(@Body History history,@Path("cid") int cid);

        @GET("/history")
        Call<ArrayList<History>> getHistory(@Query("sort") String sort, @Query("order") String order);

}
