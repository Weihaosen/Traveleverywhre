package compp.cumulus.traveleverywhre.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.adapet.ReDynamicAdapet;
import compp.cumulus.traveleverywhre.base.Basefragment;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Panmidetailsbean;
import compp.cumulus.traveleverywhre.p.Dynamicp;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Dynamicv;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicFragment extends Basefragment<Dynamicv, Dynamicp> implements Dynamicv {


    @BindView(R.id.re)
    RecyclerView mRe;
    private List<Panmidetailsbean.ResultBean.ActivitiesBean> mlist;
    private ReDynamicAdapet mreDynamicAdapet;


    @Override
    protected Dynamicp initPretener() {
        return new Dynamicp();
    }

    @Override
    protected void initView() {
        mlist=new ArrayList<>();
        mRe.setLayoutManager(new LinearLayoutManager(getContext()));
        mreDynamicAdapet = new ReDynamicAdapet(getContext(), mlist);
        mRe.setAdapter(mreDynamicAdapet);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void initData() {
        int id = getActivity().getIntent().getIntExtra("id", 0);
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.getData("api/3.0/banmi/"+id+"?page=1",token);
    }

    @Override
    public void setData(String bean) {
        Gson gson = new Gson();
        Panmidetailsbean panmidetailsbean = gson.fromJson(bean, Panmidetailsbean.class);
        if(panmidetailsbean!=null&&panmidetailsbean.getResult()!=null&&
                panmidetailsbean.getResult().getActivities().size()>0){
            mlist = panmidetailsbean.getResult().getActivities();
            mreDynamicAdapet.setData(mlist);
        }
    }
}


