package compp.cumulus.traveleverywhre.p;

import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.m.Personalm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.v.Personalv;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Personalp extends BasePertener<Personalv> {

    private Personalm mpersonalm;

    @Override
    protected void iniModel() {
        mpersonalm = new Personalm();
        mModels.add(mpersonalm);
    }

    public void setinfo(String info) {
       mpersonalm.setinfo(info, new ResultCallBack<String>() {
           @Override
           public void onSuccess(String bean) {
               if(mView!=null){
                   mView.setInfo(bean);
               }
           }

           @Override
           public void onFail(String msg) {

           }
       });
    }
}
