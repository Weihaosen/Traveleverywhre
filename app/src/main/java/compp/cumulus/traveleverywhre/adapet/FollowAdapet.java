package compp.cumulus.traveleverywhre.adapet;

import android.support.annotation.NonNull;
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
import compp.cumulus.traveleverywhre.adapet.ReAllcommentsAdapet;
import compp.cumulus.traveleverywhre.bean.Followbean;

/**
 * Created by Lenovo on 2019/5/14.
 */

public class FollowAdapet extends RecyclerView.Adapter{
    private final FollowActivity mCon;
    private final List<Followbean.ResultBean.BanmiBean> mlist;
    private List<Followbean.ResultBean.BanmiBean> data;

    public FollowAdapet(FollowActivity followActivity, List<Followbean.ResultBean.BanmiBean> mlist) {

        this.mCon = followActivity;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_panmi, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        H h = (H) holder;
        h.mdizhi.setText(mlist.get(position).getLocation());
        h.mguanzhu.setText(mlist.get(position).getFollowing()+"人关注");
        h.mmingzi.setText(mlist.get(position).getName());
        h.mzuozhe.setText(mlist.get(position).getOccupation());
        Glide.with(mCon).load(mlist.get(position).getPhoto()).into(h.mtu);


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<Followbean.ResultBean.BanmiBean> data) {
        this.mlist.addAll(data);
        notifyDataSetChanged();
    }

    class  H extends RecyclerView.ViewHolder {

        private final TextView mdizhi;
        private final TextView mmingzi;
        private final TextView mzuozhe;
        private final ImageView mtu;
        private final TextView mguanzhu;
        private final ImageView mxin;

        public H(View itemView) {
            super(itemView);
            mzuozhe = itemView.findViewById(R.id.zuozhe);
            mtu = itemView.findViewById(R.id.tu);
            mxin = itemView.findViewById(R.id.xin);
            mmingzi = itemView.findViewById(R.id.mingzi);
            mdizhi = itemView.findViewById(R.id.dizhi);
            mguanzhu = itemView.findViewById(R.id.guanzhu);

        }
    }
}
