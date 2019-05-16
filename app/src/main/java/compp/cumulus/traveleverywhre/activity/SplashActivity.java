package compp.cumulus.traveleverywhre.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.p.Splashp;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Splashv;

public class SplashActivity extends BaseActity<Splashv,Splashp>implements Splashv {

    @Override
    protected Splashp initPretener() {
        return new Splashp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        SystemClock.sleep(2000);
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        Boolean param = (Boolean) SpUtil.getParam(Constants.START, true);
        if(!TextUtils.isEmpty(token)){
            startActivity(new Intent(this,HollActivity.class));
            finish();
        }else  if(param==false){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }else{
            boolean mstart = true;
            if(mstart){
                startActivity(new Intent(this,GuidanceActivity.class));
                mstart=false;
                SpUtil.setParam(Constants.START,mstart);
                finish();
            }
        }
    }
}
