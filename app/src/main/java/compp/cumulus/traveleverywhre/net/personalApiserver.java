package compp.cumulus.traveleverywhre.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Lenovo on 2019/5/7.
 */

public interface personalApiserver {
    //http://api.banmi.com/api/3.0/account/info
    String infourl="http://api.banmi.com/";
    @GET("api/3.0/account/info")
    Observable<String> getInfo(@Header("banmi-app-token")String token);
}
