package compp.cumulus.traveleverywhre.m;

import com.google.gson.Gson;

import compp.cumulus.traveleverywhre.base.Basemodel;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.net.personalApiserver;
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
 * Created by Lenovo on 2019/5/7.
 */

public class Personalm extends Basemodel {
    public void setinfo(String info, final ResultCallBack<String> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(personalApiserver.infourl)
                .addConverterFactory(ScalarsConverterFactory.create())// 数据类型
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        personalApiserver myServer = retrofit.create(personalApiserver.class);
        Observable<String> data = myServer.getInfo(info);
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
                        Logger.logD("whs",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
