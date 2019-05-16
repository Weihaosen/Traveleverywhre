package compp.cumulus.traveleverywhre.base;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import compp.cumulus.traveleverywhre.widget.LoadingDialog;

/**
 * Created by Lenovo on 2019/5/3.
 */

public  abstract class Basefragment<V extends BaseView,P extends BasePertener> extends Fragment implements BaseView {
    protected  P mpretener;
    private Unbinder munbinder;
    private LoadingDialog mLoadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null, false);
        ButterKnife.bind(this,inflate);
        munbinder=ButterKnife.bind(this,inflate);
        mpretener=initPretener();
        if(mpretener!=null){
            mpretener.bind(this);
        }
        initView();
        initPer();
        initData();
        initListener();
        return inflate;
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
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        munbinder.unbind();
        mpretener.onDestory();
        mpretener=null;
    }
}
