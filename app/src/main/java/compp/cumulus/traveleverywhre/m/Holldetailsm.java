package compp.cumulus.traveleverywhre.m;

import com.google.gson.Gson;

import compp.cumulus.traveleverywhre.base.Basemodel;
import compp.cumulus.traveleverywhre.bean.Student;
import compp.cumulus.traveleverywhre.net.FollowApiServer;
import compp.cumulus.traveleverywhre.net.HolldetailsApiServer;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.util.Logger;
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
 * Created by Lenovo on 2019/5/10.
 */

public class Holldetailsm extends Basemodel{
    public void getData(String url,String param, final ResultCallBack<String> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HolldetailsApiServer.url)
                .addConverterFactory(ScalarsConverterFactory.create())// 数据类型
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        HolldetailsApiServer myServer = retrofit.create(HolldetailsApiServer.class);
        Observable<String> data = myServer.getData(url,param);
        data.subscribeOn(Schedulers.io())  //被观察者在子线程
                .observeOn(AndroidSchedulers.mainThread())  //观察者在主线程中执行
                .subscribe(new Observer<String>() {


                    @Override
                    public void onSubscribe(Disposable d) {
                      addDisposable(d);
                    }

                    @Override
                    public void onNext(String value) {
                        Logger.logD("wwwww",""+value);
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
    public void getlikeData(String url,String param, final ResultCallBack<String> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HolldetailsApiServer.url)
                .addConverterFactory(ScalarsConverterFactory.create())// 数据类型
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        HolldetailsApiServer myServer = retrofit.create(HolldetailsApiServer.class);
        Observable<String> data = myServer.getlikeData(url,param);
        data.subscribeOn(Schedulers.io())  //被观察者在子线程
                .observeOn(AndroidSchedulers.mainThread())  //观察者在主线程中执行
                .subscribe(new Observer<String>() {


                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(String value) {
                        Logger.logD("wwwww",""+value);
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
