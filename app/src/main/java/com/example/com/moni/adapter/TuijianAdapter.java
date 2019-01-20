package com.example.com.moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.moni.R;
import com.example.com.moni.bean.HomePageBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class TuijianAdapter extends XRecyclerView.Adapter<TuijianAdapter.ViewHolder> {
    private HomePageBean.DataBean.TuijianBean list;
    private Context context;

    public TuijianAdapter(HomePageBean.DataBean.TuijianBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tuijian_item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.price.setText(list.list.get(i).price+"");
        viewHolder.title.setText(list.list.get(i).title);
        String images = list.list.get(i).images;
        String[] split = images.split("!");
        Glide.with(context).load(split[0]).into(viewHolder.tupian);
    }

    @Override
    public int getItemCount() {
        return list.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView tupian;
        private  TextView title;
        private  TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tupian = itemView.findViewById(R.id.tuijian_image);
            title = itemView.findViewById(R.id.tuijian_title);
            price = itemView.findViewById(R.id.tuijian_price);
        }
    }
}
