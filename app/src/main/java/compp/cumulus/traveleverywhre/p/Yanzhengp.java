package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.bean.Yanzhengbean;
import compp.cumulus.traveleverywhre.m.Yanzhengm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Yanzhengv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Yanzhengp extends BasePertener<Yanzhengv> {

    private Yanzhengm myanzhengm;

    @Override
    protected void iniModel() {
        myanzhengm = new Yanzhengm();
        mModels.add(myanzhengm);
    }

    public void setData() {
        myanzhengm.setData(new ResultCallBack<Yanzhengbean>() {
            @Override
            public void onSuccess(Yanzhengbean bean) {
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
