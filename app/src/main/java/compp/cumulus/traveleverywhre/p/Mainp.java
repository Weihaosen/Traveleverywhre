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
import compp.cumulus.traveleverywhre.m.Mainm;
import compp.cumulus.traveleverywhre.net.ResultCallBack;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.MainV;

/**
 * Created by Lenovo on 2019/4/30.
 */

public class Mainp extends BasePertener<MainV> {

    private String TAG=Mainp.class.getName();
    private Mainm mainm;

    @Override
    protected void iniModel() {
        mainm = new Mainm();
        mModels.add(mainm);
    }

    public void oauth(SHARE_MEDIA type) {
            UMShareAPI umShareAPI = UMShareAPI.get(mView.getAct());
            umShareAPI.getPlatformInfo(mView.getAct(), type, umAuthListener);
        }

        UMAuthListener umAuthListener = new UMAuthListener() {
            /**
             * @desc 授权开始的回调
             * @param platform 平台名称
             */
            @Override
            public void onStart(SHARE_MEDIA platform) {

            }

            /**
             * @desc 授权成功的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param data 用户资料返回
             */
            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                logMap(data);
                if (platform == SHARE_MEDIA.SINA){
                    loginSina(data.get("uid"));
                }
            }

            /**
             * @desc 授权失败的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param t 错误原因
             */
            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            }

            /**
             * @desc 授权取消的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             */
            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {

            }
        };

    private void loginSina(String uid) {
        mainm.loginSina(uid, new ResultCallBack<Mainbean>() {
            @Override
            public void onSuccess(Mainbean bean) {
                //登录成功了,需要做什么
                //1.跳转主页面
                //2.保存用户信息
                if(bean.getResult()!=null){
                    saveUserInfo(bean.getResult());
                    Log.e(TAG, "onSuccess: "+bean.getResult());
                    mView.go2MainActivity();
                }else {
                    if (mView != null){
                        Toast.makeText(mView.getAct(), BaseApp.getRes().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                if(mView!=null){
                    Toast.makeText(mView.getAct(), msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /**
     * 保存用户信息
     * @param result
     */
    private void saveUserInfo(Mainbean.ResultBean result) {
        SpUtil.setParam(Constants.TOKEN,result.getToken());
        SpUtil.setParam(Constants.DESC,result.getDescription());
        SpUtil.setParam(Constants.USERNAME,result.getUserName());
        SpUtil.setParam(Constants.GENDER,result.getGender());
        SpUtil.setParam(Constants.EMAIL,result.getEmail());
        SpUtil.setParam(Constants.PHOTO,result.getPhoto());
        SpUtil.setParam(Constants.PHONE,result.getPhone());
    }


    private void logMap(Map<String, String> data) {
        for (Map.Entry<String, String> entry:data.entrySet()){
            Log.d(TAG, "logMap: "+entry.getKey()+","+entry.getValue());
        }
    }

}
