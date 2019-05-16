package compp.cumulus.traveleverywhre.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.adapet.ReAllcommentsAdapet;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Allcommentsbean;
import compp.cumulus.traveleverywhre.p.Allcommentsp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Allcommentsv;

public class AllcommentsActivity extends BaseActity<Allcommentsv, Allcommentsp> implements Allcommentsv {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.to)
    Toolbar mTo;
    @BindView(R.id.re)
    RecyclerView mRe;
    @BindView(R.id.sm)
    SmartRefreshLayout mSm;
    private List<Allcommentsbean.ResultBean.ReviewsBean> mlist;
    private ReAllcommentsAdapet mreAllcommentsAdapet;
    private int page=1;
    @Override
    protected Allcommentsp initPretener() {
        return new Allcommentsp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_allcomments;
    }

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra("id", 0);
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setData("api/3.0/content/routes/"+id+"/reviews?page="+page, token);
    }

    @Override
    protected void initView() {
        showLoading();
        mTo.setTitle("");
        setSupportActionBar(mTo);
        mRe.setLayoutManager(new LinearLayoutManager(this));
        mlist = new ArrayList<>();
        mreAllcommentsAdapet = new ReAllcommentsAdapet(this, mlist);
        mRe.setAdapter(mreAllcommentsAdapet);
        mSm.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                initData();
                mreAllcommentsAdapet.notifyDataSetChanged();
                mSm.finishRefresh();
            }
        });
        mSm.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
                mreAllcommentsAdapet.notifyDataSetChanged();
                mSm.finishLoadMore();
            }
        });
    }

    @Override
    public void getData(String bean) {
        Logger.logD("whsss","getData"+bean);
        Gson gson = new Gson();
        Allcommentsbean allcommentsbean = gson.fromJson(bean, Allcommentsbean.class);
        if (allcommentsbean != null && allcommentsbean.getResult() != null && allcommentsbean.getResult().getReviews().size() > 0) {
            mlist = allcommentsbean.getResult().getReviews();
            mreAllcommentsAdapet.setData(mlist);
        }
        hideLoading();
    }
}
