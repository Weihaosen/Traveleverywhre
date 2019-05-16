package compp.cumulus.traveleverywhre.net;

import java.net.ResponseCache;

import compp.cumulus.traveleverywhre.bean.Versionbean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2019/5/16.
 */

public interface VersionApiServer {
        //https://api.banmi.com/api/app/common/getVersionInfo?operating_system=android
        //http://cdn.banmi.com/banmiapp/apk/banmi_330.apk
        String verurl="http://api.banmi.com/";
        @GET("api/app/common/getVersionInfo?operating_system=android")
        Observable<Versionbean> getVerData(@Header("banmi-app-token") String token);
}
