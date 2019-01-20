package com.example.com.moni.bean;

import java.util.List;

public class HomeBean {



    public String msg;
    public String code;
    public DataBean data;


    public static class DataBean {


        public MiaoshaBean miaosha;
        public TuijianBean tuijian;
        public List<BannerBean> banner;
        public List<FenleiBean> fenlei;


        public static class MiaoshaBean {


            public String name;
            public int time;
            public List<ListBean> list;


            public static class ListBean {

                public String images;
                public double price;
                public String title;


            }
        }

        public static class TuijianBean {


            public String name;
            public List<ListBeanX> list;

            public static class ListBeanX {
                public String images;
                public double price;
                public String subhead;
                public String title;
            }
        }

        public static class BannerBean {
            public String icon;
            public String title;
            public String url;
        }

        public static class FenleiBean {
            /**
             * cid : 1
             * createtime : 2017-10-10T19:41:39
             * icon : http://120.27.23.105/images/category/shop.png
             * ishome : 1
             * name : 京东超市
             */

            public int cid;
            public String createtime;
            public String icon;
            public int ishome;
            public String name;


        }
    }
}
