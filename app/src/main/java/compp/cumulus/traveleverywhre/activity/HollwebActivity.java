package compp.cumulus.traveleverywhre.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.p.Hollwebp;
import compp.cumulus.traveleverywhre.v.Hollwebv;

public class HollwebActivity extends BaseActity<Hollwebv, Hollwebp> implements Hollwebv {


    @BindView(R.id.img_back)
    ImageView mImgBack;
    @BindView(R.id.te_biao)
    TextView mTeBiao;
    @BindView(R.id.web)
    WebView mWeb;

    @Override
    protected Hollwebp initPretener() {
        return new Hollwebp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_hollweb;
    }


    @Override
    protected void initView() {
        String url = getIntent().getStringExtra("url");
        String toobal = getIntent().getStringExtra("toobal");
        mTeBiao.setText(toobal);
        mWeb.loadUrl(url+"?os=android");
        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);






             Androidjs androidJs = new Androidjs(this);

            mWeb.addJavascriptInterface(androidJs, "android");



    }
}
