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

public class MiaoShaAdapter extends XRecyclerView.Adapter<MiaoShaAdapter.ViewHolder> {
    private Context context;
    private HomePageBean.DataBean.MiaoshaBean list;

    public MiaoShaAdapter(Context context, HomePageBean.DataBean.MiaoshaBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.miaosha_item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.text.setText(list.list.get(i).title);
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
        private  TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tupian = itemView.findViewById(R.id.miaosha_image);
            text = itemView.findViewById(R.id.miaosha_text);

        }
    }
}
