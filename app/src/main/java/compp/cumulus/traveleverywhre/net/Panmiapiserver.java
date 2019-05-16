package compp.cumulus.traveleverywhre.net;

import compp.cumulus.traveleverywhre.bean.Panmibean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2019/5/6.
 */

public interface Panmiapiserver {
    //http://api.banmi.com/api/3.0/banmi?page=3
    String panmi="http://api.banmi.com/";
    @GET("api/3.0/banmi?page=")
    Observable<Panmibean> getPanmi(@Query("page") int page, @Header("banmi-app-token")String token);
}
