package compp.cumulus.traveleverywhre.m;


import android.util.Log;

import compp.cumulus.traveleverywhre.base.Basemodel;
import compp.cumulus.traveleverywhre.bean.Hollbean;
import compp.cumulus.traveleverywhre.net.AllcommentsApiServer;
import compp.cumulus.traveleverywhre.net.CollectApiServer;
import compp.cumulus.traveleverywhre.net.HolldetailsApiServer;
import compp.cumulus.traveleverywhre.net.HollfragmentApiServer;
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

public class Collectm extends Basemodel{
    public void setData(String s, String token, final ResultCallBack<String> resultCallBack) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(CollectApiServer.url)
                    .addConverterFactory(ScalarsConverterFactory.create())// 数据类型
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        CollectApiServer myServer = retrofit.create(CollectApiServer.class);
            Observable<String> data = myServer.getData(s,token);
            data.subscribeOn(Schedulers.io())  //被观察者在子线程
                    .observeOn(AndroidSchedulers.mainThread())  //观察者在主线程中执行
                    .subscribe(new Observer<String>() {


                        @Override
                        public void onSubscribe(Disposable d) {
                            addDisposable(d);
                        }

                        @Override
                        public void onNext(String value) {
                            resultCallBack.onSuccess(value);

                        }

                        @Override
                        public void onError(Throwable e) {
                            Logger.logD("tag",e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

    }
}
