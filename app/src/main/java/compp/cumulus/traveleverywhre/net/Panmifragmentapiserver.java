package compp.cumulus.traveleverywhre.net;

import compp.cumulus.traveleverywhre.bean.Panmibean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2019/5/6.
 */

public interface Panmifragmentapiserver {
    //http://api.banmi.com/api/3.0/banmi/{banmiId}/follow
    //http://api.banmi.com/api/3.0/banmi/{banmiId}/unfollow
    String panmi="http://api.banmi.com/";
    @POST()
    Observable<String> getpanmifragmenturl(@Url String url, @Header("banmi-app-token") String token);
}
