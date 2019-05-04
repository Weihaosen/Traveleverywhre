package compp.cumulus.traveleverywhre.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.p.Yanzhengp;
import compp.cumulus.traveleverywhre.v.Yanzhengv;

public class YanzhengActivity extends BaseActity<Yanzhengv, Yanzhengp> implements Yanzhengv {
    @BindView(R.id.te_qing)
    TextView mTeQing;

    @Override
    protected Yanzhengp initPretener() {
        return new Yanzhengp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_yanzheng;
    }


    public void initView() {
    }

    @Override
    protected void initData() {

    }
}
