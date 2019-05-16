package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.m.Followm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Chatv;
import compp.cumulus.traveleverywhre.v.Followv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Followp extends BasePertener<Followv> {

    private Followm mfollowm;

    @Override
    protected void iniModel() {
        mfollowm = new Followm();
        mModels.add(mfollowm);
    }

    public void setData(String s, String token) {
        mfollowm.getData(s,token, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if(mView!=null){
                    mView.getFollowData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
