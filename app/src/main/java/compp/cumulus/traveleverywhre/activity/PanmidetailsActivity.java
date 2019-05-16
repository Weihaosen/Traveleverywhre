package compp.cumulus.traveleverywhre.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.adapet.VpPanmidetailsAdapet;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Panmidetailsbean;
import compp.cumulus.traveleverywhre.fragment.CircuitFragment;
import compp.cumulus.traveleverywhre.fragment.DynamicFragment;
import compp.cumulus.traveleverywhre.p.Panmidetailsp;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Panmidetailsv;

public class PanmidetailsActivity extends BaseActity<Panmidetailsv, Panmidetailsp> implements Panmidetailsv {


    @BindView(R.id.to)
    Toolbar mTo;
    @BindView(R.id.img_touxiang)
    ImageView mImgTouxiang;
    @BindView(R.id.te_mingzi)
    TextView mTeMingzi;
    @BindView(R.id.te_guanzhu)
    TextView mTeGuanzhu;
    @BindView(R.id.te_dizhi)
    TextView mTeDizhi;
    @BindView(R.id.te_zuozhe)
    TextView mTeZuozhe;
    @BindView(R.id.te_jieshao)
    TextView mTeJieshao;
    @BindView(R.id.ta)
    TabLayout mTa;
    @BindView(R.id.vi)
    ViewPager mVi;
    @BindView(R.id.img_xin)
    ImageView mImgXin;
    @BindView(R.id.img_back)
    ImageView mImgBack;
    @BindView(R.id.img_fenxiianng)
    ImageView mImgFenxiianng;
    @BindView(R.id.te_xinguanzhu)
    TextView mTeXinguanzhu;
    private Panmidetailsbean.ResultBean.BanmiBean mBanmi;

    @Override
    protected Panmidetailsp initPretener() {
        return new Panmidetailsp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_panmidetails;
    }

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra("id", 0);
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setData("api/3.0/banmi/" + id + "?page=1", token);
    }

    @Override
    protected void initView() {
        showLoading();
        mTo.setTitle("");
        setSupportActionBar(mTo);
        ArrayList<String> list = new ArrayList<>();
        list.add("动态");
        list.add("线路");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new DynamicFragment());
        fragments.add(new CircuitFragment());
        VpPanmidetailsAdapet vpPanmidetailsAdapet = new VpPanmidetailsAdapet(getSupportFragmentManager(), list, fragments);
        mVi.setAdapter(vpPanmidetailsAdapet);
        mTa.setupWithViewPager(mVi);
    }

    @Override
    public void setData(String bean) {
        Gson gson = new Gson();
        Panmidetailsbean panmidetailsbean = gson.fromJson(bean, Panmidetailsbean.class);
        if (panmidetailsbean != null) {
            mBanmi = panmidetailsbean.getResult().getBanmi();
            Glide.with(this).load(mBanmi.getPhoto()).into(mImgTouxiang);
            mTeDizhi.setText(mBanmi.getLocation());
            if (mBanmi.isIsFollowed()) {
                mTeXinguanzhu.setText("已关注");
                Glide.with(this).load(R.drawable.follow).into(mImgXin);
            } else {
                mTeXinguanzhu.setText("关注");
                Glide.with(this).load(R.drawable.follow_unselected).into(mImgXin);
            }
            mTeGuanzhu.setText(mBanmi.getFollowing()+"人关注");
            mTeJieshao.setText(mBanmi.getIntroduction());
            mTeZuozhe.setText(mBanmi.getOccupation());
            mTeMingzi.setText(mBanmi.getName());
        }
        hideLoading();
    }

}
