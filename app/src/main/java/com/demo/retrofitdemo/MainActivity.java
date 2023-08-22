package com.demo.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public  static String api = "https://jsonplaceholder.typicode.com";
List<UserModel> allUsersList;
RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler =findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().apiInterface.getUsers().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {

                allUsersList =response.body();
recycler.setAdapter(new MyAdapter(MainActivity.this,allUsersList));
                Log.e("api","onResponse:"+response.body().toString());

            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.e("api","onFailure:"+t.getLocalizedMessage());

            }
        });

    }
}