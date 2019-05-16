package compp.cumulus.traveleverywhre.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.adapet.ReHolldetailsAdapet;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.HollLikebean;
import compp.cumulus.traveleverywhre.bean.Holldetailsbean;
import compp.cumulus.traveleverywhre.p.Holldetailsp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.util.ToastUtil;
import compp.cumulus.traveleverywhre.v.Holldetailsv;
import compp.cumulus.traveleverywhre.widget.CircleImageView;

public class  HolldetailsActivity extends BaseActity<Holldetailsv, Holldetailsp> implements Holldetailsv {


    @BindView(R.id.te_dizhi)
    TextView mTeDizhi;
    @BindView(R.id.te_yinzuo)
    TextView mTeYinzuo;
    @BindView(R.id.img_fanhui)
    ImageView mImgFanhui;
    @BindView(R.id.text_6xiaoshi)
    TextView mText6xiaoshi;
    @BindView(R.id.img_beijingtu)
    ImageView mImgBeijingtu;
    @BindView(R.id.re_tupian)
    RelativeLayout mReTupian;
    @BindView(R.id.img_touxiang)
    CircleImageView mImgTouxiang;
    @BindView(R.id.te_mingzi)
    TextView mTeMingzi;
    @BindView(R.id.te_zhiye)
    TextView mTeZhiye;
    @BindView(R.id.te_shi)
    TextView mTeShi;
    @BindView(R.id.re_cir)
    RelativeLayout mReCir;
    @BindView(R.id.te_jieshao)
    TextView mTeJieshao;
    @BindView(R.id.re_nei)
    RelativeLayout mReNei;
    @BindView(R.id.re)
    RecyclerView mRe;
    @BindView(R.id.re_fenxiang)
    RelativeLayout mReFenxiang;
    @BindView(R.id.re_shoucang)
    RelativeLayout mReShoucang;
    @BindView(R.id.img_xing)
    ImageView mImgXing;
    @BindView(R.id.te_shouzi)
    TextView mTeShouzi;
    @BindView(R.id.te_pinglun)
    TextView mTePinglun;
    private Holldetailsbean.ResultBean.BanmiBean mjieshao;
    private List<Holldetailsbean.ResultBean.ReviewsBean> mlist;
    private Holldetailsbean.ResultBean.RouteBean mdifang;
    private ReHolldetailsAdapet mreHolldetailsAdapet;
    private boolean a = false;
    private HollLikebean mhollLikebean;
    private HollLikebean holldisLikebean;

    @Override
    protected Holldetailsp initPretener() {
        return new Holldetailsp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_holldetails;
    }

    @Override
    protected void initData() {
        int mid = getIntent().getIntExtra("mid", 0);
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setData("api/3.0/content/routes/" + mid, token);
    }

    @Override
    protected void initView() {
        showLoading();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRe.setLayoutManager(manager);
        mlist = new ArrayList<>();
        mreHolldetailsAdapet = new ReHolldetailsAdapet(this, mlist);
        mRe.setAdapter(mreHolldetailsAdapet);
    }

    @Override
    protected void initListener() {
        mReShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (a == true) {
                    mImgXing.setImageResource(R.drawable.collect_highlight);
                    mTeShouzi.setText("已收藏");
                    int id = mdifang.getId();
                    String token = (String) SpUtil.getParam(Constants.TOKEN, "");
                    mpretener.setLike("api/3.0/content/routes/" + id + "/like", token);
                    a = false;
                } else if (a == false) {
                    mImgXing.setImageResource(R.drawable.collect_default);
                    mTeShouzi.setText("取消收藏");
                    int id = mdifang.getId();
                    String token = (String) SpUtil.getParam(Constants.TOKEN, "");
                    mpretener.setdisLike("api/3.0/content/routes/" + id + "/dislike", token);
                    a = true;
                }
            }
        });
        mTePinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HolldetailsActivity.this, AllcommentsActivity.class);
                intent.putExtra("id",mdifang.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getData(String bean) {
        Logger.logD("", "hhhhhhhh" + bean);
        Gson gson = new Gson();
        Holldetailsbean holldetailsbean = gson.fromJson(bean, Holldetailsbean.class);
        if (holldetailsbean != null && holldetailsbean.getResult() != null
                && holldetailsbean.getResult().getReviews().size() > 0
                && holldetailsbean.getResult().getRoute() != null
                && holldetailsbean.getResult().getBanmi() != null) {
            mjieshao = holldetailsbean.getResult().getBanmi();
            mlist = holldetailsbean.getResult().getReviews();
            mdifang = holldetailsbean.getResult().getRoute();
            mTeDizhi.setText(mdifang.getTitle());
            mTeYinzuo.setText(mdifang.getIntro());
            mText6xiaoshi.setText(mdifang.getCity());
            Glide.with(this).load(mdifang.getCardURL()).into(mImgBeijingtu);
            Glide.with(this).load(mjieshao.getPhoto4()).into(mImgTouxiang);
            mTeMingzi.setText(mjieshao.getName());
            mTeZhiye.setText(mjieshao.getOccupation());
            mTeShi.setText(mjieshao.getLocation());
            mTeJieshao.setText(mjieshao.getIntroduction());
            mTePinglun.setText("查看全部"+holldetailsbean.getResult().getReviewsCount()+"条评论");
            if (mlist.size() > 0) {
                Logger.logD("wwwwwww", "wwwwwwww" + mlist);
                mreHolldetailsAdapet.setData(mlist);
            }
        }
        hideLoading();
    }

    @Override
    public void getLike(String bean) {
        Logger.logD("wwww", "shou" + bean);
        Gson gson = new Gson();
        mhollLikebean = gson.fromJson(bean, HollLikebean.class);
        if (mhollLikebean != null && mhollLikebean.getResult() != null) {
            String desc = mhollLikebean.getDesc();
            ToastUtil.showShort(desc);
        }
    }

    @Override
    public void getdisLike(String bean) {
        Logger.logD("wwww", "shoucang" + bean);
        Gson gson = new Gson();
        holldisLikebean = gson.fromJson(bean, HollLikebean.class);
        if (holldisLikebean != null && holldisLikebean.getResult() != null) {
            String desc = holldisLikebean.getDesc();
            ToastUtil.showShort(desc);
        }
    }

}
