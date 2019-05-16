package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.m.CircuitFragmentm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Chatv;
import compp.cumulus.traveleverywhre.v.Dynamicv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Dynamicp extends BasePertener<Dynamicv> {

    private CircuitFragmentm mcircuitFragmentm;

    @Override
    protected void iniModel(){
        mcircuitFragmentm = new CircuitFragmentm();
        mModels.add(mcircuitFragmentm);
    }

    public void getData(String s, String token) {
        mcircuitFragmentm.setData(s, token, new ResultCallBack<String>() {
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
