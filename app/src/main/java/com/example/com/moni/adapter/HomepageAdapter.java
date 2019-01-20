package com.example.com.moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.com.moni.R;
import com.example.com.moni.bean.HomePageBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

public class HomepageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private HomePageBean.DataBean data;
    private Context context;
    private List<HomePageBean.DataBean.MiaoshaBean> miaoshalist = new ArrayList<>();

    public HomepageAdapter(HomePageBean.DataBean data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {  //轮播
            View inflate = LayoutInflater.from(context).inflate(R.layout.flybanner_layout, viewGroup, false);
            BannerHolder bannerHolder = new BannerHolder(inflate);
            return bannerHolder;

        }
        if (i == 1) { //分类
            View inflate = LayoutInflater.from(context).inflate(R.layout.fenlei_layout, viewGroup, false);
            FenleiHolder fenleiHolder = new FenleiHolder(inflate);
            return fenleiHolder;

        }
        if (i == 2) { //秒杀
            View inflate = LayoutInflater.from(context).inflate(R.layout.miaosha_layout, viewGroup, false);
            MiaoshaHolder miaoshaHolder = new MiaoshaHolder(inflate);
            return miaoshaHolder;

        }
        if (i== 3) {  //推荐
            View inflate = LayoutInflater.from(context).inflate(R.layout.tuijian_layout, viewGroup, false);
            TuijianHolder tuijianHolder = new TuijianHolder(inflate);
            return tuijianHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if (holder instanceof BannerHolder) { //轮播
            List<String> lists = new ArrayList<>();
            for (HomePageBean.DataBean.BannerBean bannerBean : data.banner) {
                lists.add(bannerBean.icon);
            }

            ((BannerHolder) holder).banner.setImagesUrl(lists);
        } else if (holder instanceof FenleiHolder) { //分类

            ((FenleiHolder) holder).fenlei.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false));
            List<HomePageBean.DataBean.FenleiBean> fenlei = data.fenlei;


            FenleiAdapter fenleiAdapter = new FenleiAdapter(fenlei, context);
            ((FenleiHolder) holder).fenlei.setAdapter(fenleiAdapter);

        } else if (holder instanceof MiaoshaHolder) { //秒杀
            ((MiaoshaHolder) holder).miaosha.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            MiaoShaAdapter miaoShaAdapter = new MiaoShaAdapter(context, data.miaosha);
            ((MiaoshaHolder) holder).miaosha.setAdapter(miaoShaAdapter);

        } else if (holder instanceof TuijianHolder) {  //推荐
            ((TuijianHolder) holder).tuijian.setLayoutManager(new GridLayoutManager(context,2));
            TuijianAdapter tuijianAdapter = new TuijianAdapter(data.tuijian, context);
            ((TuijianHolder) holder).tuijian.setAdapter(tuijianAdapter);


        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        int q = 0;
        switch (position) {
            case 0:
                q = 0;
                break;
            case 1:
                q = 1;
                break;
            case 2:
                q = 2;
                break;
            case 3:
                q = 3;
                break;
        }
        return q;
    }

    public class BannerHolder extends RecyclerView.ViewHolder {
        private FlyBanner banner;

        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.homeFlybanner);
        }
    }

    public class FenleiHolder extends RecyclerView.ViewHolder {

        private RecyclerView fenlei;

        public FenleiHolder(@NonNull View itemView) {
            super(itemView);
            fenlei = itemView.findViewById(R.id.fenLeiXRecy);

        }
    }

    public class MiaoshaHolder extends RecyclerView.ViewHolder {

        private RecyclerView miaosha;

        public MiaoshaHolder(@NonNull View itemView) {
            super(itemView);
            miaosha = itemView.findViewById(R.id.miaoShaXRecy);
        }
    }

    public class TuijianHolder extends RecyclerView.ViewHolder {

        private RecyclerView tuijian;

        public TuijianHolder(@NonNull View itemView) {
            super(itemView);
            tuijian = itemView.findViewById(R.id.tuiJianXRecy);
        }
    }

}
