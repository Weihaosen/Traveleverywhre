package compp.cumulus.traveleverywhre.m;


import android.util.Log;

import com.google.gson.Gson;

import compp.cumulus.traveleverywhre.base.Basemodel;
import compp.cumulus.traveleverywhre.bean.Mainbean;
import compp.cumulus.traveleverywhre.net.MainApiService;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.util.BaseObserver;
import compp.cumulus.traveleverywhre.util.HttpUtils;
import compp.cumulus.traveleverywhre.util.RxUtils;
import io.reactivex.Observable;
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

public class Mainm extends Basemodel {


    public void loginSina(String uid, final ResultCallBack<Mainbean> resultCallBack) {
        MainApiService apiserver = HttpUtils.getInstance().getApiserver(MainApiService.BASE_URL, MainApiService.class);
        apiserver.postWeiboLogin(uid)
                .compose(RxUtils.<Mainbean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Mainbean>() {
                    @Override
                    public void error(String msg) {
                        Log.e("whs", "error: "+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                    @Override
                    public void onNext(Mainbean loginInfo) {
                        if (loginInfo != null){
                            if (loginInfo.getCode() == MainApiService.SUCCESS_CODE){
                                Log.e("whs", "onNext: "+loginInfo.getResult().getToken());
                                resultCallBack.onSuccess(loginInfo);
                            }else {
                                resultCallBack.onFail(loginInfo.getDesc());
                            }
                        }
                    }
                });
    }
}
