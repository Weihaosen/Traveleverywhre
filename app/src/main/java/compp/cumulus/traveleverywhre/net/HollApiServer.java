package compp.cumulus.traveleverywhre.net;

import compp.cumulus.traveleverywhre.bean.Hollbean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Lenovo on 2019/5/6.
 */

public interface HollApiServer {
    //http://api.banmi.com/api/3.0/account/balance
    String url="http://api.banmi.com/";
    @GET("api/3.0/account/balance")
    Observable<String> getData(@Header("banmi-app-token") String banmi);
}
