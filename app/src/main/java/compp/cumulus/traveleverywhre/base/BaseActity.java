package compp.cumulus.traveleverywhre.base;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/4/30.
 */

public abstract class BaseActity<V extends BaseView,P extends BasePertener> extends AppCompatActivity implements BaseView{
    protected P mpretener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mpretener=initPretener();
        if(mpretener!=null){
          mpretener.bind(this);
        }
        initView();
        initPer();
        initData();
        initListener();
    }

    private void initPer() {
        String[] per = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, per, 100);
    }

    protected abstract P initPretener();

    protected  void initData(){}

    protected void  initListener(){}

    protected  void initView(){}

    public abstract int getLayoutId() ;
}
