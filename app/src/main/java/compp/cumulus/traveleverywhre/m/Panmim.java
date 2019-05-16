package compp.cumulus.traveleverywhre.m;


import android.util.Log;

import compp.cumulus.traveleverywhre.base.Basemodel;
import compp.cumulus.traveleverywhre.bean.Panmibean;
import compp.cumulus.traveleverywhre.net.Panmiapiserver;
import compp.cumulus.traveleverywhre.net.Panmifragmentapiserver;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
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
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Lenovo on 2019/5/5.
 */

public class Panmim extends Basemodel {


    public void setData(int page,String panmi, final ResultCallBack<Panmibean> resultCallBack) {
        Panmiapiserver apiserver = HttpUtils.getInstance().getApiserver(Panmiapiserver.panmi, Panmiapiserver.class);
        apiserver.getPanmi(page,panmi)
                .compose(RxUtils.<Panmibean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Panmibean>() {
                    @Override
                    public void error(String msg) {
                        Log.e("whs", "error: "+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Panmibean loginInfo) {
                        Log.e("whs", "onNext: "+loginInfo );
                        if (loginInfo != null){
                                resultCallBack.onSuccess(loginInfo);
                        }
                    }
                });
    }
    public void setPanmiData(String url, String param, final ResultCallBack<String> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Panmifragmentapiserver.panmi)
                .addConverterFactory(ScalarsConverterFactory.create())// 数据类型
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Panmifragmentapiserver myServer = retrofit.create(Panmifragmentapiserver.class);
        Observable<String> data = myServer.getpanmifragmenturl(url, param);
        data.subscribeOn(Schedulers.io())  //被观察者在子线程
                .observeOn(AndroidSchedulers.mainThread())  //观察者在主线程中执行
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(String value) {
                        Logger.logD("whs",value);
                        resultCallBack.onSuccess(value);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
