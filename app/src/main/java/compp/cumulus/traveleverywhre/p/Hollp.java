package compp.cumulus.traveleverywhre.p;

import android.util.Log;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseApp;
import compp.cumulus.traveleverywhre.base.BasePertener;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Mainbean;
import compp.cumulus.traveleverywhre.m.Hollm;
import compp.cumulus.traveleverywhre.m.Mainm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Hollv;
import compp.cumulus.traveleverywhre.v.MainV;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Hollp extends BasePertener<Hollv> {

    private Hollm mhollm;

    protected void iniModel() {
        mhollm = new Hollm();
        mModels.add(mhollm);
    }


    public void getData(String token) {
        mhollm.setData(token, new ResultCallBack<String>() {
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
