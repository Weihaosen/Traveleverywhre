package compp.cumulus.traveleverywhre.net;

import compp.cumulus.traveleverywhre.bean.Yanzhengbean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Lenovo on 2019/5/6.
 */

public interface YanzhengApiserver {
    //http://yun918.cn/study/public/index.php/
    String Yanzhengurl="http://yun918.cn/study/public/index.php/";
    @GET("verify")
    Observable<Yanzhengbean> getYanzheng();
}
