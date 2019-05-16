package compp.cumulus.traveleverywhre.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2019/5/13.
 */

public interface AllcommentsApiServer {
    //https://api.banmi.com/api/3.0/content/routes/82/reviews?page=1
    String url="https://api.banmi.com/";
    @GET()
    Observable<String> getData(@Url String url, @Header("banmi-app-token") String banmi);
}
