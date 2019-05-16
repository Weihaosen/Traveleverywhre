package compp.cumulus.traveleverywhre.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.activity.HolldetailsActivity;
import compp.cumulus.traveleverywhre.activity.OtherActivity;
import compp.cumulus.traveleverywhre.adapet.ReHolladapet;
import compp.cumulus.traveleverywhre.base.Basefragment;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Hollbean;
import compp.cumulus.traveleverywhre.p.Hollfragmentp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Holldetailsv;
import compp.cumulus.traveleverywhre.v.Hollfragmentv;

/**
 * A simple {@link Fragment} subclass.
 */
public class HollFragment extends Basefragment<Hollfragmentv, Hollfragmentp> implements Hollfragmentv {


    @BindView(R.id.re)
    RecyclerView mRe;
    private List<Hollbean.ResultBean.BannersBean> mban;
    private List<Hollbean.ResultBean.RoutesBean> mlist;
    private ReHolladapet mreHolladapet;
    private String TAG=HollFragment.class.getName();


    @Override
    protected Hollfragmentp initPretener() {
        return new Hollfragmentp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_holl;
    }


    @Override
    protected void initView() {
        mlist=new ArrayList<>();
        mban=new ArrayList<>();
        mRe.setLayoutManager(new LinearLayoutManager(getContext()));
        mreHolladapet = new ReHolladapet(getContext(), mban, mlist);
        mRe.setAdapter(mreHolladapet);
        mreHolladapet.setOnItemClickListener(new ReHolladapet.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {
                Intent intent = new Intent(getContext(), HolldetailsActivity.class);
                intent.putExtra("mid",mlist.get(position).getId());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setData(token);
    }

    @Override
    public void setData(Hollbean bean) {
        Log.e(TAG, "setData:"+bean );
        if(bean!=null&&bean.getResult()!=null&&bean.getResult().getBanners().size()>0){
             mban = bean.getResult().getBanners();
            mreHolladapet.setDataBanner(mban);
        }
        if(bean!=null&&bean.getResult()!=null&&bean.getResult().getRoutes().size()>0){
            mlist = bean.getResult().getRoutes();
            mreHolladapet.setDatalist(mlist);
        }

    }
}
