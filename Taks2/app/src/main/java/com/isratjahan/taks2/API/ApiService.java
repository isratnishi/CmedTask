package com.isratjahan.taks2.API;
import com.isratjahan.taks2.Model.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users.json")
    Call<Users> getAllUsers();
}