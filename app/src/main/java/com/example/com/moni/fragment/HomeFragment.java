package com.example.com.moni.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.com.moni.R;
import com.example.com.moni.adapter.HomepageAdapter;
import com.example.com.moni.bean.HomeBean;
import com.example.com.moni.bean.HomePageBean;
import com.example.com.moni.contract.JDContract;
import com.example.com.moni.presenter.Presenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A fragment with a Google +1 button.
 */
public class HomeFragment extends Fragment implements JDContract.JDView {


    private XRecyclerView homeXRecy;
    private Presenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);

        presenter = new Presenter(this);
        presenter.homePresenter(new HashMap<String, String>());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


    }


    private void initView(View view) {
        homeXRecy = (XRecyclerView) view.findViewById(R.id.homeXRecy);
        homeXRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void success(String view) {
        Gson gson = new Gson();
        Log.d("qqqq", view);
        HomePageBean homePageBean = gson.fromJson(view, HomePageBean.class);
        HomePageBean.DataBean data = homePageBean.data;
        Log.d("ttttttttttt", homePageBean.code);

        HomepageAdapter homepageAdapter = new HomepageAdapter(data, getActivity());
        homeXRecy.setAdapter(homepageAdapter);

    }

    @Override
    public void failure(String error) {

    }
}
