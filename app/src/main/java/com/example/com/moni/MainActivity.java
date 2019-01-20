package com.example.com.moni;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.com.moni.adapter.ViewpagerAdapter;
import com.example.com.moni.fragment.HomeFragment;
import com.example.com.moni.fragment.IndentFragment;
import com.example.com.moni.fragment.MineFragment;
import com.example.com.moni.fragment.MomentFragment;
import com.example.com.moni.fragment.ShoppingCartFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottombar)
    BottomBar bottombar;
    @BindView(R.id.myviewpager)
    ViewPager viewPager;

    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        //给list添加控件
        list.add(new HomeFragment());
        list.add(new IndentFragment());
        list.add(new MomentFragment());
        list.add(new ShoppingCartFragment());
        list.add(new MineFragment());
        //给viewpager添加适配器
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(viewpagerAdapter);
        //bottonbar的点击事件
        bottombar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "首页", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.indent:
                        Toast.makeText(MainActivity.this, "分类", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.moment:
                        Toast.makeText(MainActivity.this, "发现", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.shoppingcart:
                        Toast.makeText(MainActivity.this, "购物车", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.mine:
                        Toast.makeText(MainActivity.this, "我的", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });


    }
}
