package compp.cumulus.traveleverywhre.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.adapet.ReCollectAdapet;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Collectbean;
import compp.cumulus.traveleverywhre.p.Collectp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Collectv;

public class CollectActivity extends BaseActity<Collectv, Collectp> implements Collectv {

    @BindView(R.id.re)
    RecyclerView mRe;
    private List<Collectbean.ResultBean.CollectedRoutesBean> mlist;
    private ReCollectAdapet mreCollectAdapet;

    @Override
    protected Collectp initPretener() {
        return new Collectp();
    }

    @Override
    protected void initData() {
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setData("api/3.0/account/collectedRoutes?page=1",token);
    }

    @Override
    protected void initView() {
        showLoading();
        mRe.setLayoutManager(new LinearLayoutManager(this));
        mlist=new ArrayList<>();
        mreCollectAdapet = new ReCollectAdapet(this, mlist);
        mRe.setAdapter(mreCollectAdapet);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_collect;
    }


    @Override
    public void getData(String bean) {
        Logger.logD("colllllll",""+bean);
        Gson gson = new Gson();
        Collectbean collectbean = gson.fromJson(bean, Collectbean.class);
        if(collectbean!=null&&collectbean.getResult()!=null
                &&collectbean.getResult().getCollectedRoutes().size()>0){
            mlist = collectbean.getResult().getCollectedRoutes();
            mreCollectAdapet.setData(mlist);
        }
        hideLoading();
    }
}
