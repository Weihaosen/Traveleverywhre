package compp.cumulus.traveleverywhre.fragment;


import android.content.Intent;
import android.os.Bundle;
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
import butterknife.OnClick;
import butterknife.Unbinder;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.activity.PanmidetailsActivity;
import compp.cumulus.traveleverywhre.adapet.RePanmiAdapet;
import compp.cumulus.traveleverywhre.base.Basefragment;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Panmibean;
import compp.cumulus.traveleverywhre.bean.Panmifragmentfollow;
import compp.cumulus.traveleverywhre.bean.Panmiframgnetunfollow;
import compp.cumulus.traveleverywhre.p.Panmip;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.util.ToastUtil;
import compp.cumulus.traveleverywhre.v.Panmiv;

/**
 * A simple {@link Fragment} subclass.
 */
public class PanmiFragment extends Basefragment<Panmiv, Panmip> implements Panmiv {

     private int mpage=1;
    private int munid;
    private int mid;
    @BindView(R.id.re)
    RecyclerView mRe;
    private List<Panmibean.ResultBean.BanmiBean> mlist;
    private RePanmiAdapet mrePanmiAdapet;
    private Panmifragmentfollow.ResultBean mfoll;
    private Panmiframgnetunfollow.ResultBean munfoll;
    private String mtoken;

    @Override
    protected Panmip initPretener() {
        return new Panmip();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_panmi;
    }

    @Override
    protected void initView() {
        mRe.setLayoutManager(new LinearLayoutManager(getContext()));
        mlist=new ArrayList<>();
        mrePanmiAdapet = new RePanmiAdapet(getContext(),mlist);
        mRe.setAdapter(mrePanmiAdapet);
        mrePanmiAdapet.setOnFollowCliclListener(new RePanmiAdapet.OnFollowCliclListener() {
            @Override
            public void Follow(int id) {
                Log.e("wswf", "unFollow: "+id );
                mpretener.setPanmiunfollow("api/3.0/banmi/"+id+"/follow",mtoken);
            }

            @Override
            public void unFollow(int id) {
                Log.e("asdasd", "Follow: "+id );
                mpretener.setPanmifollow("api/3.0/banmi/"+id+"/unfollow",mtoken);
            }

        });
    }

    @Override
    protected void initListener() {
        mrePanmiAdapet.setOnItemClickListener(new RePanmiAdapet.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {
                Intent intent = new Intent(getContext(), PanmidetailsActivity.class);
                intent.putExtra("id",mlist.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mtoken = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setPanmi(mpage,mtoken);

    }

    @Override
    public void setData(Panmibean bean) {
        if(bean!=null&&bean.getResult()!=null&&bean.getResult().getBanmi()!=null&&bean.getResult().getBanmi().size()>0){
            mlist = bean.getResult().getBanmi();
            mrePanmiAdapet.setData(mlist);
        }
    }

    @Override
    public void getPanmifragmentunData(String bean) {
        Logger.logD("unxin","wwwww"+bean);
        Gson gson = new Gson();
        Panmiframgnetunfollow munfollw = gson.fromJson(bean, Panmiframgnetunfollow.class);
        if(munfollw!=null&&munfollw.getResult()!=null){
            munfoll = munfollw.getResult();
            ToastUtil.showLong(munfoll.getMessage());
        }

    }

    @Override
    public void getPanmifragmentData(String bean) {
        Logger.logD("xin","wwwww"+bean);
        Gson gson = new Gson();
        Panmifragmentfollow mfollw = gson.fromJson(bean, Panmifragmentfollow.class);
        if(mfollw!=null&&mfollw.getResult()!=null){
            mfoll = mfollw.getResult();
            ToastUtil.showLong(mfoll.getMessage());
        }
    }
}
