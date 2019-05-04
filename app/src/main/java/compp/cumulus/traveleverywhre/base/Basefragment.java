package compp.cumulus.traveleverywhre.base;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/5/3.
 */

public  abstract class Basefragment<V extends BaseView,P extends BasePertener> extends Fragment implements BaseView {
    protected  P mpretener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null, false);
        ButterKnife.bind(this,inflate);
        mpretener=initPretener();
        if(mpretener!=null){
            mpretener.bind(this);
            return  inflate;
        }
        initView();
        initPer();
        initData();
        initListener();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initPer() {
        String[] per = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(getActivity(), per, 100);
    }

    protected abstract P initPretener();

    protected  void initData(){}

    protected void  initListener(){}

    protected  void initView(){}

    public abstract int getLayoutId() ;
}
