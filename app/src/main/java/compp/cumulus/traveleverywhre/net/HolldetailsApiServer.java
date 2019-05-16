package compp.cumulus.traveleverywhre.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2019/5/6.
 */

public interface HolldetailsApiServer {
    //http://api.banmi.com/api/3.0/content/routes/196

    String url="http://api.banmi.com/";
    @GET()
    Observable<String> getData(@Url String url, @Header("banmi-app-token") String banmi);

    @POST()
    Observable<String> getlikeData(@Url String url, @Header("banmi-app-token") String banmi);
}
