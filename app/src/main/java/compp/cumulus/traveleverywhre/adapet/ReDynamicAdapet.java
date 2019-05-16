package compp.cumulus.traveleverywhre.adapet;

import android.animation.StateListAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.activity.FollowActivity;
import compp.cumulus.traveleverywhre.bean.Followbean;
import compp.cumulus.traveleverywhre.bean.Panmidetailsbean;
import compp.cumulus.traveleverywhre.util.Logger;

/**
 * Created by Lenovo on 2019/5/14.
 */

public class ReDynamicAdapet extends RecyclerView.Adapter{


    private  Context mCon;
    private  List<Panmidetailsbean.ResultBean.ActivitiesBean> mlist;
    private List<Panmidetailsbean.ResultBean.ActivitiesBean> data;
    private List<String> mimglist;

    public ReDynamicAdapet(Context context, List<Panmidetailsbean.ResultBean.ActivitiesBean> mlist) {

        this.mCon = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_dynamic, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        H h = (H) holder;
        h.mshijian.setText(mlist.get(position).getDate());
        h.mbiaoti.setText(mlist.get(position).getContent());
        h.mzanshu.setText(mlist.get(position).getLikeCount()+"");
        h.mpingshu.setText(mlist.get(position).getReplyCount()+"");
        if(mlist.get(position).getImages().size()>0){
            mimglist = mlist.get(position).getImages();
            GridLayoutManager Manager = new GridLayoutManager(mCon, 3);
            h.mre.setLayoutManager(Manager);
            ReXiaoDynamicAdapet reXiaoDynamicAdapet = new ReXiaoDynamicAdapet(mCon, mimglist);
            h.mre.setAdapter(reXiaoDynamicAdapet);
        }else {
            h.mre.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<Panmidetailsbean.ResultBean.ActivitiesBean> data) {
        this.mlist.addAll(data);
        notifyDataSetChanged();
    }


    class  H extends RecyclerView.ViewHolder {

        private  RecyclerView mre;
        private  TextView mshijian;
        private  ImageView mzan;
        private  TextView mbiaoti;
        private  TextView mpingshu;
        private  TextView mzanshu;

        public H(View itemView) {
            super(itemView);
            mshijian = itemView.findViewById(R.id.te_shijian);
            mzan = itemView.findViewById(R.id.zan);
            mzanshu = itemView.findViewById(R.id.zanshu);
            mbiaoti = itemView.findViewById(R.id.te_biaoti);
            mpingshu = itemView.findViewById(R.id.pingshu);
            mre = itemView.findViewById(R.id.re);

        }
    }
}
