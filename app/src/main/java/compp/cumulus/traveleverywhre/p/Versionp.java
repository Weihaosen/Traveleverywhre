package compp.cumulus.traveleverywhre.p;

import android.util.Log;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.bean.Hollbean;
import compp.cumulus.traveleverywhre.bean.Versionbean;
import compp.cumulus.traveleverywhre.m.Versionm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Chatv;
import compp.cumulus.traveleverywhre.v.Versionv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Versionp extends BasePertener<Versionv> {


    private Versionm mversionm;

    @Override
    protected void iniModel() {
        mversionm = new Versionm();
        mModels.add(mversionm);
    }

    public void setData(String token) {
        mversionm.setData(token, new ResultCallBack<Versionbean>() {
            @Override
            public void onSuccess(Versionbean bean) {
                if(mView!=null){
                    mView.setData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
