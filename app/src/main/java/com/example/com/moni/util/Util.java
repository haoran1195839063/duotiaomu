package com.example.com.moni.util;

import android.os.Handler;

import com.example.com.moni.api.Api;
import com.example.com.moni.model.Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class Util {
    private Handler handler = new Handler();

    public void getDatas(HashMap<String, String> pamrame, final Model.ModelCallBack modelCallBack,String url) {
        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        FormBody.Builder builder = new FormBody.Builder();

        for (Map.Entry<String, String> stringStringEntry : pamrame.entrySet()) {
            builder.add(stringStringEntry.getKey(), stringStringEntry.getValue());
        }

        OkHttpClient build = new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();


        Request build1 = new Request.Builder().url(url).post(builder.build()).build();
        build.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                modelCallBack.filure("失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        modelCallBack.success(string);
                    }
                });

            }
        });
    }
}
