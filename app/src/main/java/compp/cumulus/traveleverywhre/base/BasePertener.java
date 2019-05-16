package compp.cumulus.traveleverywhre.base;

import java.util.ArrayList;

import compp.cumulus.traveleverywhre.v.MainV;

/**
 * Created by Lenovo on 2019/4/30.
 */

public abstract class BasePertener<V extends BaseView> {

    protected V mView;
    protected ArrayList<Basemodel> mModels = new ArrayList<>();

    public BasePertener() {
     iniModel();
    }

    protected abstract void iniModel();

    public void bind(V View) {
        this.mView = View;
    }

    public  void onDestory(){
        mView=null;
        if (mModels.size()>0){
            for (Basemodel model : mModels) {
               model.onDestory();
            }
        }
    }
}
