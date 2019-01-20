package com.example.com.moni.contract;

import com.example.com.moni.model.Model;

import java.util.HashMap;

public interface JDContract {
    interface JDModel {
        void getData(HashMap<String, String> pamrame, Model.ModelCallBack modelCallBack);
    }

    interface JDView {
        void success(String view);

        void failure(String error);
    }

    abstract class JDPresenter {
        public abstract void startPresenter(HashMap<String, String> pamrame);
    }
}
