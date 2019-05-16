package compp.cumulus.traveleverywhre.bean;

import java.util.List;

/**
 * Created by Lenovo on 2019/5/14.
 */

public class Circuitfragmentbean {

    /**
     * code : 0
     * desc :
     * result : {"count":6,"page":1,"limit":20,"routes":[{"id":86,"cityID":1,"priceInCents":190,"title":"新宿","intro":"7小时教你如何逛得清新脱俗","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510746259454_3f5bd37de0da28f901580b3478144a65.jpg","videoURL":"","sequence":631,"isPurchased":false,"isCollected":false,"city":"日本·东京","price":"1.9","date":"2017-06-07 00:43"},{"id":81,"cityID":1,"priceInCents":190,"title":"吉祥寺","intro":"7小时东京人气街区NO.1","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510728189818_93cb364a522e6d7ccbcdf534ccea66ab.jpg","videoURL":"","sequence":1206,"isPurchased":false,"isCollected":false,"city":"日本·东京","price":"1.9","date":"2017-06-04 17:09"},{"id":92,"cityID":10,"priceInCents":190,"title":"清水寺","intro":"7小时京都古风小道徒步之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510641662704_a27ae250663216d9f12815da7a259a92.jpg","videoURL":"","sequence":1408,"isPurchased":false,"isCollected":false,"city":"日本·京都","price":"1.9","date":"2017-06-07 20:14"},{"id":82,"cityID":10,"priceInCents":190,"title":"三条通商店街","intro":"5小时京都逛街指南","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510641456418_8b4f3fc1d91a9c8e4131aa35e43eda69.jpg","videoURL":"","sequence":1471,"isPurchased":false,"isCollected":false,"city":"日本·京都","price":"1.9","date":"2017-06-05 22:15"},{"id":83,"cityID":10,"priceInCents":190,"title":"锦市场及周边","intro":"6小时带你吃遍京都地道美食","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510718015545_2d0589b2a14a9903a17fd66f970cfbee.jpg","videoURL":"","sequence":1538,"isPurchased":false,"isCollected":false,"city":"日本·京都","price":"1.9","date":"2017-06-06 10:32"},{"id":28,"cityID":10,"priceInCents":190,"title":"祇园","intro":"5小时漫步京都艺伎风情街","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510640485062_7636c5a9ad03db5aa17fa5816d4d0fb5.jpg","videoURL":"","sequence":1588,"isPurchased":false,"isCollected":false,"city":"日本·京都","price":"1.9","date":"2017-04-21 23:26"}]}
     */

    private int code;
    private String desc;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * count : 6
         * page : 1
         * limit : 20
         * routes : [{"id":86,"cityID":1,"priceInCents":190,"title":"新宿","intro":"7小时教你如何逛得清新脱俗","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510746259454_3f5bd37de0da28f901580b3478144a65.jpg","videoURL":"","sequence":631,"isPurchased":false,"isCollected":false,"city":"日本·东京","price":"1.9","date":"2017-06-07 00:43"},{"id":81,"cityID":1,"priceInCents":190,"title":"吉祥寺","intro":"7小时东京人气街区NO.1","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510728189818_93cb364a522e6d7ccbcdf534ccea66ab.jpg","videoURL":"","sequence":1206,"isPurchased":false,"isCollected":false,"city":"日本·东京","price":"1.9","date":"2017-06-04 17:09"},{"id":92,"cityID":10,"priceInCents":190,"title":"清水寺","intro":"7小时京都古风小道徒步之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510641662704_a27ae250663216d9f12815da7a259a92.jpg","videoURL":"","sequence":1408,"isPurchased":false,"isCollected":false,"city":"日本·京都","price":"1.9","date":"2017-06-07 20:14"},{"id":82,"cityID":10,"priceInCents":190,"title":"三条通商店街","intro":"5小时京都逛街指南","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510641456418_8b4f3fc1d91a9c8e4131aa35e43eda69.jpg","videoURL":"","sequence":1471,"isPurchased":false,"isCollected":false,"city":"日本·京都","price":"1.9","date":"2017-06-05 22:15"},{"id":83,"cityID":10,"priceInCents":190,"title":"锦市场及周边","intro":"6小时带你吃遍京都地道美食","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510718015545_2d0589b2a14a9903a17fd66f970cfbee.jpg","videoURL":"","sequence":1538,"isPurchased":false,"isCollected":false,"city":"日本·京都","price":"1.9","date":"2017-06-06 10:32"},{"id":28,"cityID":10,"priceInCents":190,"title":"祇园","intro":"5小时漫步京都艺伎风情街","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510640485062_7636c5a9ad03db5aa17fa5816d4d0fb5.jpg","videoURL":"","sequence":1588,"isPurchased":false,"isCollected":false,"city":"日本·京都","price":"1.9","date":"2017-04-21 23:26"}]
         */

        private int count;
        private int page;
        private int limit;
        private List<RoutesBean> routes;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public List<RoutesBean> getRoutes() {
            return routes;
        }

        public void setRoutes(List<RoutesBean> routes) {
            this.routes = routes;
        }

        public static class RoutesBean {
            /**
             * id : 86
             * cityID : 1
             * priceInCents : 190
             * title : 新宿
             * intro : 7小时教你如何逛得清新脱俗
             * cardURL : http://cdn.banmi.com/banmiapp/rahdna/1510746259454_3f5bd37de0da28f901580b3478144a65.jpg
             * videoURL :
             * sequence : 631
             * isPurchased : false
             * isCollected : false
             * city : 日本·东京
             * price : 1.9
             * date : 2017-06-07 00:43
             */

            private int id;
            private int cityID;
            private int priceInCents;
            private String title;
            private String intro;
            private String cardURL;
            private String videoURL;
            private int sequence;
            private boolean isPurchased;
            private boolean isCollected;
            private String city;
            private String price;
            private String date;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCityID() {
                return cityID;
            }

            public void setCityID(int cityID) {
                this.cityID = cityID;
            }

            public int getPriceInCents() {
                return priceInCents;
            }

            public void setPriceInCents(int priceInCents) {
                this.priceInCents = priceInCents;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getCardURL() {
                return cardURL;
            }

            public void setCardURL(String cardURL) {
                this.cardURL = cardURL;
            }

            public String getVideoURL() {
                return videoURL;
            }

            public void setVideoURL(String videoURL) {
                this.videoURL = videoURL;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public boolean isIsPurchased() {
                return isPurchased;
            }

            public void setIsPurchased(boolean isPurchased) {
                this.isPurchased = isPurchased;
            }

            public boolean isIsCollected() {
                return isCollected;
            }

            public void setIsCollected(boolean isCollected) {
                this.isCollected = isCollected;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
