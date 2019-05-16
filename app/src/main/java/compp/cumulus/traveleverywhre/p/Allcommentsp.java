package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.m.Allcommentsm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Allcommentsv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Allcommentsp extends BasePertener<Allcommentsv> {

    private Allcommentsm mallcommentsm;

    @Override
    protected void iniModel() {
        mallcommentsm = new Allcommentsm();
        mModels.add(mallcommentsm);
    }

    public void setData(String s, String token) {
        mallcommentsm.setData(s, token, new ResultCallBack<String>() {
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
