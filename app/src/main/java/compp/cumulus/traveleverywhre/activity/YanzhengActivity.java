package compp.cumulus.traveleverywhre.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.BaseApp;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Yanzhengbean;
import compp.cumulus.traveleverywhre.p.Yanzhengp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.util.UIUtils;
import compp.cumulus.traveleverywhre.v.Yanzhengv;
import compp.cumulus.traveleverywhre.widget.IdentifyingCodeView;

public class YanzhengActivity extends BaseActity<Yanzhengv, Yanzhengp> implements Yanzhengv {
    @BindView(R.id.te_qing)
    TextView mTeQing;
    @BindView(R.id.fan)
    ImageView mFan;
    @BindView(R.id.icv)
    IdentifyingCodeView mIcv;
    @BindView(R.id.chongxin)
    TextView mChongxin;
    @BindView(R.id.te_yan)
    TextView mTeYan;
    private String mdata;
    private  int mTime;
    private Handler mHandler=new Handler();


    @Override
    protected Yanzhengp initPretener() {
        return new Yanzhengp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_yanzheng;
    }


    public void initView() {
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mChongxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mTime=30;
                TIme();
            }
        });
        mIcv.setOnEditorActionListener(new IdentifyingCodeView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }

            @Override
            public void onTextChanged(String s) {
                Logger.println(mIcv.getTextContent());
                if (mIcv.getTextContent().length()>=4){
                    //自动登录
                    Toast.makeText(YanzhengActivity.this, "自动登录", Toast.LENGTH_SHORT).show();
                    mIcv.setBackgroundEnter(false);
                    mTeQing.setVisibility(View.VISIBLE);
                    mTeYan.setVisibility(View.GONE);
                    startActivity(new Intent(YanzhengActivity.this,HollActivity.class));
                    finish();
                }
            }
        });
    }

    private void TIme() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mChongxin.setText("重新发送"+"("+mTime+"s"+")");
                mTime--;
                mChongxin.setTextColor(UIUtils.getColor(R.color.c_999999));
                mChongxin.setClickable(false);
                if (mTime == 0){
                    //mTvTime.setClickable(false);
                    mChongxin.setText("重新发送");
                    mChongxin.setTextColor(UIUtils.getColor(R.color.c_fa6a13));
                    mChongxin.setClickable(true);
                    mHandler.removeCallbacks(this);
                    mpretener.setData();
                }else {
                    mChongxin.setText("重新发送"+"("+mTime+"s"+")");
                    mHandler.postDelayed(this,1000);
                }
            }
        },1000);
    }


    @Override
    protected void initData() {
        mpretener.setData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void setData(Yanzhengbean bean) {
        mdata = bean.getData();
        mTeYan.setText(mdata);
    }

}
