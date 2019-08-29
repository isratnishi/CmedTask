package com.isratjahan.taks2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.isratjahan.taks2.API.ApiService;
import com.isratjahan.taks2.API.RetroClient;
import com.isratjahan.taks2.Adapter.UserAdapter;
import com.isratjahan.taks2.Model.User;
import com.isratjahan.taks2.Model.Users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> usersList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private UserAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        setProgrss();
        getAllList();
    }
    public void setProgrss(){
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }
    public void getAllList(){
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<Users> call = api.getAllUsers();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    usersList = response.body().getUsers();

                    eAdapter = new UserAdapter(usersList,MainActivity.this);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
}





