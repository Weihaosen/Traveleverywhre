package compp.cumulus.traveleverywhre.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.p.Otherp;
import compp.cumulus.traveleverywhre.v.Otherv;

public class OtherActivity extends BaseActity<Otherv, Otherp> implements Otherv {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.te_biaoti)
    TextView mTeBiaoti;
    @BindView(R.id.web)
    WebView mWeb;

    @Override
    protected Otherp initPretener() {
        return new Otherp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_other;
    }

    @Override
    protected void initView() {
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        mTeBiaoti.setText(title);
        mWeb.loadUrl(url);
    }
}
