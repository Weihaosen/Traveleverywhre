package compp.cumulus.traveleverywhre.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.just.agentweb.AgentWeb;
import butterknife.BindView;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Basefragment;
import compp.cumulus.traveleverywhre.p.Webviewp;
import compp.cumulus.traveleverywhre.v.Webviewv;

public class WebviewActivity extends BaseActity<Webviewv, Webviewp> implements Webviewv {

    @BindView(R.id.te_biaoti)
    TextView mTeBiaoti;
    @BindView(R.id.to)
    Toolbar mTo;
    @BindView(R.id.li_web)
    LinearLayout mLiWeb;
    private AgentWeb mAgentWeb;


    @Override
    protected Webviewp initPretener() {
        return new Webviewp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {
        // 亮色状态栏 可以帮我们修改颜色
        StatusBarUtil.setLightMode(this);
        mTo.setTitle("");
        setSupportActionBar(mTo);
        mTo.setNavigationIcon(R.mipmap.back_white);
        mTo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mAgentWeb.back()) {
                  finish();
                }
            }
        });
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mLiWeb, new LinearLayout.LayoutParams(-1, -1))
                .closeIndicator()
                .createAgentWeb()
                .ready()
                .go("https://api.banmi.com/app2017/agreement.html");

        mAgentWeb.getWebCreator().getWebView().setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (!TextUtils.isEmpty(title)) {
                    mTeBiaoti.setText(title);
                }
                super.onReceivedTitle(view, title);
            }
        });
    }

    @Override
    public void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    public void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    public static void startAct(MainActivity mainActivity) {
        Intent intent = new Intent(mainActivity, WebviewActivity.class);
        mainActivity.startActivity(intent);
    }

}
