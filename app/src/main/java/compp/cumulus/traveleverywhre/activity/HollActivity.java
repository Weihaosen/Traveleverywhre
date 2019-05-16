package compp.cumulus.traveleverywhre.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.adapet.VpHollAdapet;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Hollyue;
import compp.cumulus.traveleverywhre.fragment.HollFragment;
import compp.cumulus.traveleverywhre.fragment.PanmiFragment;
import compp.cumulus.traveleverywhre.p.Hollp;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Hollv;
import compp.cumulus.traveleverywhre.widget.CircleImageView;

public class HollActivity extends BaseActity<Hollv, Hollp> implements Hollv {

    @BindView(R.id.to)
    Toolbar mTo;
    @BindView(R.id.vi)
    ViewPager mVi;
    @BindView(R.id.ta)
    TabLayout mTa;
    @BindView(R.id.na)
    NavigationView mNa;
    @BindView(R.id.dr)
    DrawerLayout mDr;
    @BindView(R.id.img_na)
    ImageView mImgNa;
    @BindView(R.id.touxiang)
    CircleImageView mTouxiang;
    @BindView(R.id.mingzi)
    TextView mMingzi;
    @BindView(R.id.qianming)
    TextView mQianming;
    @BindView(R.id.re_bianyi)
    RelativeLayout mReBianyi;
    @BindView(R.id.shuzi)
    TextView mShuzi;
    @BindView(R.id.coll)
    LinearLayout mColl;
    @BindView(R.id.follow)
    LinearLayout mFollow;
    @BindView(R.id.li_banben)
    LinearLayout mLiBanben;
    private Hollyue.ResultBean mListyue;


    @Override
    protected Hollp initPretener() {
        return new Hollp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_holl;
    }

    @Override
    protected void initView() {
        showLoading();

        mTo.setTitle("");
        setSupportActionBar(mTo);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HollFragment());
        fragments.add(new PanmiFragment());
        ArrayList<String> list = new ArrayList<>();
        list.add("首页");
        list.add("伴米");
        VpHollAdapet vpHollAdapet = new VpHollAdapet(getSupportFragmentManager(), fragments, list);
        mVi.setAdapter(vpHollAdapet);
        mTa.setupWithViewPager(mVi);
        mTa.getTabAt(0).setIcon(R.drawable.holl);
        mTa.getTabAt(1).setIcon(R.drawable.panmi);
        mNa.setItemIconTintList(null);
        iniNa();
    }

    @Override
    protected void initData() {
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.getData(token);
    }

    private void iniNa() {
        // 头像 名字  签名
        String ming = (String) SpUtil.getParam(Constants.MINGZI, "");
        String qian = (String) SpUtil.getParam(Constants.QIANMING, "");
        String tou = (String) SpUtil.getParam(Constants.TOUXIANG, "");
        mMingzi.setText(ming);
        mQianming.setText(qian);
        Glide.with(this).load(tou).into(mTouxiang);

        findViewById(R.id.re_bianyi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HollActivity.this, PersonalActivity.class));
            }
        });
        findViewById(R.id.follow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HollActivity.this, FollowActivity.class));
            }
        });
        findViewById(R.id.coll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HollActivity.this, CollectActivity.class));
            }
        });
        findViewById(R.id.li_banben).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HollActivity.this,VersionActivity.class));
            }
        });

    }


    @OnClick({R.id.img_na, R.id.li_banben})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img_na:
                mDr.openDrawer(Gravity.LEFT);
                break;
        }
    }

    @Override
    public void setData(String bean) {
        Gson gson = new Gson();
        Hollyue hollyue = gson.fromJson(bean, Hollyue.class);
        if (hollyue != null && hollyue.getResult() != null) {
            mListyue = hollyue.getResult();
            mShuzi.setText(mListyue.getBalance());

        }
        hideLoading();
    }

}
