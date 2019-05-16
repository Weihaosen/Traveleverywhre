package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.bean.Hollbean;
import compp.cumulus.traveleverywhre.m.Hollfragmentm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Hollfragmentv;

/**
 * Created by Lenovo on 2019/5/4.
 */

public class Hollfragmentp extends BasePertener<Hollfragmentv> {

    private Hollfragmentm mhollm;
    private String TAG=Hollfragmentp.class.getName();

    @Override
    protected void iniModel() {
        mhollm = new Hollfragmentm();
        mModels.add(mhollm);
    }

    public void setData(String panmi) {
     mhollm.setData(panmi, new ResultCallBack<Hollbean>() {
         @Override
         public void onSuccess(Hollbean bean) {
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
