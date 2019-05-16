package compp.cumulus.traveleverywhre.m;


import android.renderscript.Sampler;
import android.util.Log;

import com.google.gson.Gson;

import compp.cumulus.traveleverywhre.activity.VersionActivity;
import compp.cumulus.traveleverywhre.base.Basemodel;
import compp.cumulus.traveleverywhre.bean.Hollbean;
import compp.cumulus.traveleverywhre.bean.Student;
import compp.cumulus.traveleverywhre.bean.Versionbean;
import compp.cumulus.traveleverywhre.net.HollfragmentApiServer;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.net.VersionApiServer;
import compp.cumulus.traveleverywhre.util.BaseObserver;
import compp.cumulus.traveleverywhre.util.HttpUtils;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.RxUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Lenovo on 2019/5/5.
 */

public class Versionm extends Basemodel {
    public void setData(String token, final ResultCallBack<Versionbean> resultCallBack) {
        VersionApiServer apiserver = HttpUtils.getInstance().getApiserver(VersionApiServer.verurl, VersionApiServer.class);
        apiserver.getVerData(token)
                .compose(RxUtils.<Versionbean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Versionbean>() {
                    @Override
                    public void error(String msg) {
                        Log.e("whs", "error: "+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Versionbean loginInfo) {
                        Log.e("whs", "onNext: "+loginInfo );
                        if (loginInfo != null){
                            resultCallBack.onSuccess(loginInfo);
                        }
                    }
                });
    }
}
