package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.bean.Panmibean;
import compp.cumulus.traveleverywhre.m.Panmifragmentm;
import compp.cumulus.traveleverywhre.m.Panmim;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Panmiv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Panmip extends BasePertener<Panmiv> {

    private Panmim mpanmim;

    protected void iniModel() {
        mpanmim = new Panmim();
        mModels.add(mpanmim);
    }


    public void setPanmi(int mpage, String param) {
        mpanmim.setData(mpage, param, new ResultCallBack<Panmibean>() {
            @Override
            public void onSuccess(Panmibean bean) {
                if(mView!=null){
                    mView.setData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void setPanmifollow(final String url, final String param) {
        mpanmim.setPanmiData(url,param, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if(mView!=null){
                    mView.getPanmifragmentData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });

    }

    public void setPanmiunfollow(final String url, final String param) {
        mpanmim.setPanmiData(url,param, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if(mView!=null){
                    mView.getPanmifragmentunData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
