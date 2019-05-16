package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.m.Holldetailsm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Chatv;
import compp.cumulus.traveleverywhre.v.Holldetailsv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Holldetailsp extends BasePertener<Holldetailsv> {


    private Holldetailsm mholldetailsm;

    @Override
    protected void iniModel() {
        mholldetailsm = new Holldetailsm();
        mModels.add(mholldetailsm);
    }

    public void setData(String url, String token) {
        mholldetailsm.getData(url, token, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if(mView!=null){
                    mView.getData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void setLike(String url, String token) {
        mholldetailsm.getlikeData(url, token, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if(mView!=null){
                    mView.getLike(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });

    }

    public void setdisLike(String url, String token) {
        mholldetailsm.getlikeData(url, token, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if (mView != null) {
                    mView.getdisLike(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
