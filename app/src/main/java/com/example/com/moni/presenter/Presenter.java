package com.example.com.moni.presenter;

import com.example.com.moni.contract.JDContract;
import com.example.com.moni.model.Model;
import com.google.gson.Gson;

import java.util.HashMap;

public class Presenter extends JDContract.JDPresenter {

    private Model model;
    private JDContract.JDView view;

    public Presenter(JDContract.JDView view) {
        this.model = new Model();
        this.view = view;
    }

    @Override
    public void startPresenter(HashMap<String, String> pamrame) {
        model.getData(pamrame, new Model.ModelCallBack() {
            @Override
            public void success(String data) {
                view.success(data);
            }

            @Override
            public void filure(String error) {
                view.failure(error);
            }
        });
    }

    public void homePresenter(HashMap<String, String> pamrame) {
        model.getHome(pamrame, new Model.ModelCallBack() {
            @Override
            public void success(String data) {
                view.success(data);
            }

            @Override
            public void filure(String error) {
                view.failure(error);
            }
        });
    }

}
