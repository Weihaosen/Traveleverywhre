package compp.cumulus.traveleverywhre.bean;

/**
 * Created by Lenovo on 2019/5/7.
 */

public class Student {

    /**
     * code : 200
     * res : 上传文件成功
     * data : {"url":"http://yun918.cn/study/public/uploadfiles/123/a.jpg"}
     */

    private int code;
    private String res;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url : http://yun918.cn/study/public/uploadfiles/123/a.jpg
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
