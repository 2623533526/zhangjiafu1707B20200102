package com.bawei.zhangjiafu1707b20200102;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient okHttpClient;
    Handler handler=new Handler();
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url("http://172.17.8.100/small/commodity/v1/bannerShow")
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                          try {
                              new DemoDao()
                              String string = response.body().string();
                              Gson gson = new Gson();
                              ListEntity listEntity = gson.fromJson(string, ListEntity.class);
                              MyRecycler myRecycler = new MyRecycler(MainActivity.this, listEntity.getResult());
                              rv.setAdapter(myRecycler);

                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                      }
                  });
            }
        });
    }
}
