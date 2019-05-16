package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.m.Panmidetailsm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Chatv;
import compp.cumulus.traveleverywhre.v.Panmidetailsv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Panmidetailsp extends BasePertener<Panmidetailsv> {

    private Panmidetailsm mpanmidetailsm;

    @Override
    protected void iniModel() {
        mpanmidetailsm = new Panmidetailsm();
        mModels.add(mpanmidetailsm);
    }

    public void setData(String url, String token) {
        mpanmidetailsm.setData(url, token, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
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
