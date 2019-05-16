package compp.cumulus.traveleverywhre.net;

import compp.cumulus.traveleverywhre.bean.Hollbean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Lenovo on 2019/5/10.
 */

public interface HollfragmentApiServer {
//http://api.banmi.com/api/3.0/content/routesbundles?page=1
    String url="http://api.banmi.com/";
    @GET("api/3.0/content/routesbundles?page=1")
    Observable<Hollbean> getData(@Header("banmi-app-token") String token);
}
