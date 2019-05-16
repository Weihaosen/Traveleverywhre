package compp.cumulus.traveleverywhre.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.adapet.FollowAdapet;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Followbean;
import compp.cumulus.traveleverywhre.p.Followp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Followv;

public class FollowActivity extends BaseActity<Followv, Followp> implements Followv {

    @BindView(R.id.re)
    RecyclerView mRe;
    private List<Followbean.ResultBean.BanmiBean> mlist;
    private FollowAdapet mfollowAdapet;
    @Override
    protected Followp initPretener() {
        return new Followp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_follow;
    }

    @Override
    protected void initView() {
        showLoading();
        mlist = new ArrayList<>();
        mRe.setLayoutManager(new LinearLayoutManager(this));
        mfollowAdapet = new FollowAdapet(this, mlist);
        mRe.setAdapter(mfollowAdapet);

    }

    @Override
    protected void initData() {
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setData("api/3.0/account/followedBanmi?page=1", token);
    }

    @Override
    public void getFollowData(String bean) {
        Logger.logD("whs","getFollow"+bean);
        Gson gson = new Gson();
        Followbean followbean = gson.fromJson(bean, Followbean.class);
        if (followbean != null && followbean.getResult() != null && followbean.getResult().getBanmi() != null
                && followbean.getResult().getBanmi().size() > 0) {
            mlist = followbean.getResult().getBanmi();
            mfollowAdapet.setData(mlist);
        }
        hideLoading();
    }

}
