package compp.cumulus.traveleverywhre.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lenovo on 2019/5/3.
 */

public class Basemodel{
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public void onDestory() {
        mCompositeDisposable.clear();
    }
    public void addDisposable(Disposable d){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }

}
