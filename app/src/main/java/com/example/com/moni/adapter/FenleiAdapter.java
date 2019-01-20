package com.example.com.moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class FenleiAdapter extends XRecyclerView.Adapter<FenleiAdapter.ViewHolder> {
    private List<HomePageBean.DataBean.FenleiBean> list;
    private Context context;

    public FenleiAdapter(List<HomePageBean.DataBean.FenleiBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fenlei_iten_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("qwer",list.get(i).name);
        viewHolder.text.setText(list.get(i).name);
        Glide.with(context).load(list.get(i).icon).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private  TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.fenlei_image) ;
            text = itemView.findViewById(R.id.fenlei_text);
        }
    }
}
