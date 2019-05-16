package compp.cumulus.traveleverywhre.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2019/5/12.
 */

public interface FollowApiServer {
    //https://api.banmi.com/api/3.0/account/followedBanmi?page=1
    String url="https://api.banmi.com/";
    @GET()
    Observable<String> getData(@Url String url, @Header("banmi-app-token")String token);
}
