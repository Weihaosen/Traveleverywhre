package compp.cumulus.traveleverywhre.bean;

import java.util.List;

/**
 * Created by Lenovo on 2019/5/12.
 */

public class Followbean {

    /**
     * code : 0
     * desc :
     * result : {"page":1,"limit":20,"count":1,"banmi":[{"id":16,"name":"山崎宽斗","location":"东京","occupation":"旅游媒体人","introduction":"大家好，我的中文名字叫山崎宽斗。大学时，我去北京师范大学留学过半年，这半年我努力地跑遍了大半个中国。游玩过程中，我学会了讲中文，弱弱地说，普通的会话能力应该没问题。如果有兴趣，来日本找我吧！你也可以沿着我策划的线路走一走，感觉一下我想传达给你的日本的魅力。","following":3427,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1511750678879_59d0146a509c62365bbd791a2a1f9a45.jpg","isFollowed":true}]}
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
         * page : 1
         * limit : 20
         * count : 1
         * banmi : [{"id":16,"name":"山崎宽斗","location":"东京","occupation":"旅游媒体人","introduction":"大家好，我的中文名字叫山崎宽斗。大学时，我去北京师范大学留学过半年，这半年我努力地跑遍了大半个中国。游玩过程中，我学会了讲中文，弱弱地说，普通的会话能力应该没问题。如果有兴趣，来日本找我吧！你也可以沿着我策划的线路走一走，感觉一下我想传达给你的日本的魅力。","following":3427,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1511750678879_59d0146a509c62365bbd791a2a1f9a45.jpg","isFollowed":true}]
         */

        private int page;
        private int limit;
        private int count;
        private List<BanmiBean> banmi;

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

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<BanmiBean> getBanmi() {
            return banmi;
        }

        public void setBanmi(List<BanmiBean> banmi) {
            this.banmi = banmi;
        }

        public static class BanmiBean {
            /**
             * id : 16
             * name : 山崎宽斗
             * location : 东京
             * occupation : 旅游媒体人
             * introduction : 大家好，我的中文名字叫山崎宽斗。大学时，我去北京师范大学留学过半年，这半年我努力地跑遍了大半个中国。游玩过程中，我学会了讲中文，弱弱地说，普通的会话能力应该没问题。如果有兴趣，来日本找我吧！你也可以沿着我策划的线路走一走，感觉一下我想传达给你的日本的魅力。
             * following : 3427
             * photo : http://cdn.banmi.com/banmiapp/rahdna/1511750678879_59d0146a509c62365bbd791a2a1f9a45.jpg
             * isFollowed : true
             */

            private int id;
            private String name;
            private String location;
            private String occupation;
            private String introduction;
            private int following;
            private String photo;
            private boolean isFollowed;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getOccupation() {
                return occupation;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public int getFollowing() {
                return following;
            }

            public void setFollowing(int following) {
                this.following = following;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public boolean isIsFollowed() {
                return isFollowed;
            }

            public void setIsFollowed(boolean isFollowed) {
                this.isFollowed = isFollowed;
            }
        }
    }
}
