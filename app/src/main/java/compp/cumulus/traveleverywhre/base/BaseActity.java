package compp.cumulus.traveleverywhre.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import butterknife.ButterKnife;
import compp.cumulus.traveleverywhre.widget.LoadingDialog;

/**
 * Created by Lenovo on 2019/4/30.
 */

public abstract class BaseActity<V extends BaseView,P extends BasePertener> extends AppCompatActivity implements BaseView{
    protected P mpretener;
    private LoadingDialog mLoadingDialog;
    protected File sd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mpretener=initPretener();
        if(mpretener!=null){
          mpretener.bind(this);
        }
        initPer();
        initView();
        initSD();
        initData();
        initListener();
    }

    private void initPer() {
        String[] per = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, per, 100);
    }
    private void initSD() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED){
            openSd();
        }else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==100&&grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
            openSd();
        }
    }

    private void openSd() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            sd = Environment.getExternalStorageDirectory();
        }
    }

    protected abstract P initPretener();

    protected  void initData(){}

    protected void  initListener(){}

    protected  void initView(){}

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpretener.onDestory();
        mpretener=null;
    }

    public void showLoading(){
        if(mLoadingDialog==null){
            mLoadingDialog=new LoadingDialog(this);
        }
        mLoadingDialog.show();
    }

    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()){
            mLoadingDialog.dismiss();
        }
    }

}
