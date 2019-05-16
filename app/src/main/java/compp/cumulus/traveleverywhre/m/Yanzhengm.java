package compp.cumulus.traveleverywhre.m;

import compp.cumulus.traveleverywhre.base.Basemodel;
import compp.cumulus.traveleverywhre.bean.Mainbean;
import compp.cumulus.traveleverywhre.bean.Yanzhengbean;
import compp.cumulus.traveleverywhre.net.MainApiService;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.net.YanzhengApiserver;
import compp.cumulus.traveleverywhre.util.BaseObserver;
import compp.cumulus.traveleverywhre.util.HttpUtils;
import compp.cumulus.traveleverywhre.util.RxUtils;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lenovo on 2019/5/6.
 */

public class Yanzhengm  extends Basemodel{


    public void setData(final ResultCallBack<Yanzhengbean> data) {
        YanzhengApiserver apiserver = HttpUtils.getInstance().getApiserver(YanzhengApiserver.Yanzhengurl, YanzhengApiserver.class);
        apiserver.getYanzheng()
                .compose(RxUtils.<Yanzhengbean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Yanzhengbean>() {
                    @Override
                    public void error(String msg) {

                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Yanzhengbean loginInfo) {
                       data.onSuccess(loginInfo);
                    }
                });
    }
}
