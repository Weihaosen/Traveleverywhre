package compp.cumulus.traveleverywhre.m;


import android.util.Log;

import compp.cumulus.traveleverywhre.base.Basemodel;
import compp.cumulus.traveleverywhre.bean.Hollbean;
import compp.cumulus.traveleverywhre.net.HollfragmentApiServer;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.util.BaseObserver;
import compp.cumulus.traveleverywhre.util.HttpUtils;
import compp.cumulus.traveleverywhre.util.RxUtils;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lenovo on 2019/5/5.
 */

public class Hollfragmentm extends Basemodel {


    public void setData(String panmi, final ResultCallBack<Hollbean> resultCallBack) {
        HollfragmentApiServer apiserver = HttpUtils.getInstance().getApiserver(HollfragmentApiServer.url, HollfragmentApiServer.class);
        apiserver.getData(panmi)
                .compose(RxUtils.<Hollbean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Hollbean>() {
                    @Override
                    public void error(String msg) {
                        Log.e("whs", "error: "+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Hollbean loginInfo) {
                        Log.e("whs", "onNext: "+loginInfo );
                        if (loginInfo != null){
                                resultCallBack.onSuccess(loginInfo);
                        }
                    }
                });
    }
}
