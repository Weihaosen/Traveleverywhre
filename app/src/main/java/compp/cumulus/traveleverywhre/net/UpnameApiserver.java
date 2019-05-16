package compp.cumulus.traveleverywhre.net;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2019/5/7.
 */

public interface UpnameApiserver {
    //http://api.banmi.com/api/3.0/account/updateInfo
    String infourl="http://api.banmi.com/";
    @POST("api/3.0/account/updateInfo")
    Observable<String> getUpname(@FieldMap Map<String,Object> map, @Header("banmi-app-token") String token);
}
