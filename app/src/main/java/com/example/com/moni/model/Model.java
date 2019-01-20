package com.example.com.moni.model;

import android.os.Handler;

import com.example.com.moni.api.Api;
import com.example.com.moni.contract.JDContract;
import com.example.com.moni.util.Util;

import java.util.HashMap;


public class Model implements JDContract.JDModel {


    //登录
    @Override
    public void getData(HashMap<String, String> pamrame, final ModelCallBack modelCallBack) {
        //实例化util 调用方法请求数据
        Util util = new Util();
        util.getDatas(pamrame, modelCallBack,Api.login);

    }


    //获取首页内容
    public void getHome(HashMap<String, String> pamrame, final ModelCallBack modelCallBack){
        //实例化util 调用方法请求数据
        Util util = new Util();
        util.getDatas(pamrame,modelCallBack,Api.homepage);

    }


    //定义一个接口用来传值
    private ModelCallBack modelCallBack;

    public void setModelCallBack(ModelCallBack modelCallBack) {
        this.modelCallBack = modelCallBack;
    }

    public interface ModelCallBack {
        void success(String data);

        void filure(String error);
    }
}
