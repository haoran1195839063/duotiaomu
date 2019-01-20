package com.example.com.moni.bean;

import java.util.List;

public class HomePageBean {

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
            public String time;
            public List<ListBean> list;

            public static class ListBean {


                public double bargainPrice;
                public String createtime;
                public String detailUrl;
                public String images;
                public String itemtype;
                public String pid;
                public double price;
                public String pscid;
                public String salenum;
                public String sellerid;
                public String subhead;
                public String title;

            }
        }

        public static class TuijianBean {


            public String name;
            public List<ListBeanX> list;

            public static class ListBeanX {

                public double bargainPrice;
                public String createtime;
                public String detailUrl;
                public String images;
                public String itemtype;
                public String pid;
                public double price;
                public String pscid;
                public String salenum;
                public String sellerid;
                public String subhead;
                public String title;

            }
        }

        public static class BannerBean {

            public String aid;
            public String createtime;
            public String icon;
            public Object productId;
            public String title;
            public String type;
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

            public String cid;
            public String createtime;
            public String icon;
            public String ishome;
            public String name;

        }
    }
}
