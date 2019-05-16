package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.m.Collectm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Collectv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Collectp extends BasePertener<Collectv> {

    private Collectm mcollectm;

    @Override
    protected void iniModel() {
        mcollectm = new Collectm();
        mModels.add(mcollectm);
    }

    public void setData(String url,String token) {
        mcollectm.setData(url,token, new ResultCallBack<String>() {
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
}
