package compp.cumulus.traveleverywhre.bean;

/**
 * Created by Lenovo on 2019/5/13.
 */

public class HollLikebean {

    /**
     * code : 0
     * desc : 收藏成功
     * result : {}
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
    }
}