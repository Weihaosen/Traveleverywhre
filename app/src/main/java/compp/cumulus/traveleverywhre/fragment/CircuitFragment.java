package compp.cumulus.traveleverywhre.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
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
import compp.cumulus.traveleverywhre.adapet.ReCircuitfraggmentAdapet;
import compp.cumulus.traveleverywhre.base.Basefragment;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Circuitfragmentbean;
import compp.cumulus.traveleverywhre.p.Circuitfragmentp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Circuitfragmentv;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircuitFragment extends Basefragment<Circuitfragmentv, Circuitfragmentp> implements Circuitfragmentv {


    @BindView(R.id.re)
    RecyclerView mRe;
    private List<Circuitfragmentbean.ResultBean.RoutesBean> mlist;
    private ReCircuitfraggmentAdapet mreCircuitfragment;

    @Override
    protected Circuitfragmentp initPretener() {
        return new Circuitfragmentp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_circuit;
    }

    @Override
    protected void initView() {
        mlist=new ArrayList<>();
        mRe.setLayoutManager(new LinearLayoutManager(getContext()));
        mreCircuitfragment = new ReCircuitfraggmentAdapet(getContext(),mlist);
        mRe.setAdapter(mreCircuitfragment);

    }

    @Override
    protected void initData() {
        int id = getActivity().getIntent().getIntExtra("id", 0);
        Logger.logD("whs","id"+id);
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setData("api/3.0/banmi/"+id+"/routes?page=1",token);
    }

    @Override
    public void getData(String bean) {
        Logger.logD("","sgsgsxvxc"+bean);
        Gson gson = new Gson();
        Circuitfragmentbean circuitfragmentbean = gson.fromJson(bean, Circuitfragmentbean.class);
        if(circuitfragmentbean!=null&&circuitfragmentbean.getResult()!=null
                &&circuitfragmentbean.getResult().getRoutes().size()>0){
            mlist = circuitfragmentbean.getResult().getRoutes();
            mreCircuitfragment.setData(mlist);
        }
    }
}
