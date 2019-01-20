package com.example.com.moni.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.moni.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * A fragment with a Google +1 button.
 */
public class ShoppingCartFragment extends Fragment {


    private XRecyclerView shoppingcart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        initView(view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    private void initView(View view) {
        shoppingcart = (XRecyclerView) view.findViewById(R.id.shoppingcart);
    }
}
