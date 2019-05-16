package compp.cumulus.traveleverywhre.activity;


import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.mm.opensdk.utils.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Versionbean;
import compp.cumulus.traveleverywhre.net.VersionApiServer;
import compp.cumulus.traveleverywhre.p.Versionp;
import compp.cumulus.traveleverywhre.util.InstallUtil;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.util.ToastUtil;
import compp.cumulus.traveleverywhre.util.Tools;
import compp.cumulus.traveleverywhre.v.Versionv;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class VersionActivity extends BaseActity<Versionv, Versionp> implements Versionv {


    @BindView(R.id.te_jian)
    TextView mTeJian;
    @BindView(R.id.te_tuijian)
    TextView mTeTuijian;
    private Versionbean.ResultBean.InfoBean minfo;
    private String TAG=VersionApiServer.class.getName();

    @Override
    protected Versionp initPretener() {
        return new Versionp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_version;
    }

    @Override
    protected void initData() {
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setData(token);
    }
    @Override
    protected void initListener() {
        mTeTuijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String versionName = Tools.getVersionName();
                if(!versionName.equals(mTeJian)){
                    new AlertDialog.Builder(VersionActivity.this)
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("最新版本："+minfo.getVersion()+"\n\n"
                                    +"当前版本："+versionName+"\n\n"
                                    +"更新内容：\n"+"  1.增加***功能\n"+"  2.用户界面优化")
                            .setNegativeButton("以后再说", null)
                            .setPositiveButton("立即升级", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showShort("正在下载中");
                                    iniXiazai();
                                }
                            })
                            .show();
                }
            }
        });
    }
    private void iniXiazai() {
        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    URL url = new URL("http://cdn.banmi.com/banmiapp/apk/banmi_330.apk");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    int responseCode = con.getResponseCode();
                    if (responseCode == 200){
                        InputStream inputStream = con.getInputStream();
                        int max = con.getContentLength();

                        saveFile(inputStream,sd+"/"+"daochu.apk",max);
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void saveFile(InputStream inputStream, final String s, long max) {
        //读写的进度
        long count = 0;
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(s));

            byte[] bys = new byte[1024*10];
            int length = -1;

            while((length = inputStream.read(bys))!=-1){
                outputStream.write(bys,0,length);

                count += length;

                Log.d(TAG, "progress: "+count +"  max:"+max);
            }

            inputStream.close();
            outputStream.close();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(VersionActivity.this,"下载完成",Toast.LENGTH_SHORT).show();
                    InstallUtil.installApk(VersionActivity.this,s);
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setData(Versionbean bean) {
        if(bean!=null&&bean.getResult()!=null&&bean.getResult().getInfo()!=null){
            minfo = bean.getResult().getInfo();
            mTeJian.setText("版本号"+minfo.getVersion());
            mTeTuijian.setText("推荐:"+minfo.getRecommend());
        }
    }
}
