package compp.cumulus.traveleverywhre.base;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import java.io.File;

import compp.cumulus.traveleverywhre.util.CrashHandler;

/**
 * Created by Lenovo on 2019/5/3.
 */

public class BaseApp extends Application{
    private static BaseApp baseApp;
    public static int mWidthPixels;
    public static int mHeightPixels;
    private RefWatcher mWatcher;

    //默认不是夜间模式
    @Override
    public void onCreate() {
        super.onCreate();
        baseApp=this;
        getScreenWH();
        initUmeng();
        iniCrash();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        mWatcher = LeakCanary.install(this);
        // Normal app init code...
    }
/*
*
* 全局异常捕捉
* */
    private void iniCrash() {
        CrashHandler instance = CrashHandler.getInstance();
        instance.init(BaseApp.getInstance());
    }


    private void initUmeng() {
        UMConfigure.init(this, "5c0a1ce9b465f541250001c5", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        UMConfigure.setLogEnabled(true);
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("4289141299", "d8988429aaf2bdaba2ac9e09b2a29df7","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }


    public void getScreenWH() {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;
    }

    public static BaseApp getInstance(){
        return baseApp;
    }
    public static Resources getRes() {
        return baseApp.getResources();
    }
}
