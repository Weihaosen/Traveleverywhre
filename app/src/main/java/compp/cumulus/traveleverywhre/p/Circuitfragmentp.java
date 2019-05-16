package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.m.CircuitFragmentm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Chatv;
import compp.cumulus.traveleverywhre.v.Circuitfragmentv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Circuitfragmentp extends BasePertener<Circuitfragmentv> {

    private CircuitFragmentm mcircuitFragmentm;

    @Override
    protected void iniModel() {
        mcircuitFragmentm = new CircuitFragmentm();
        mModels.add(mcircuitFragmentm);
    }

    public void setData(String s, String token) {
        mcircuitFragmentm.setData(s, token, new ResultCallBack<String>() {
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
