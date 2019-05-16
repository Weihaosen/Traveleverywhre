package compp.cumulus.traveleverywhre.adapet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.activity.CollectActivity;
import compp.cumulus.traveleverywhre.activity.HolldetailsActivity;
import compp.cumulus.traveleverywhre.bean.Collectbean;
import compp.cumulus.traveleverywhre.bean.Holldetailsbean;

/**
 * Created by Lenovo on 2019/5/12.
 */

public class ReCollectAdapet extends RecyclerView.Adapter {
    private  CollectActivity mCon;
    private  List<Collectbean.ResultBean.CollectedRoutesBean> mlist;

    public ReCollectAdapet(CollectActivity holldetailsActivity, List<Collectbean.ResultBean.CollectedRoutesBean> mlist) {
        this.mCon = holldetailsActivity;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_collect, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        H h= (H) holder;
        h.mdizhi.setText(mlist.get(position).getTitle());
        h.mjieshao.setText(mlist.get(position).getIntro());
        Glide.with(mCon).load(mlist.get(position).getCardURL()).into(h.mimg);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<Collectbean.ResultBean.CollectedRoutesBean> data) {
        this.mlist.addAll(data);
        notifyDataSetChanged();
    }

    class  H extends RecyclerView.ViewHolder {

        private final ImageView mimg;
        private final TextView mjieshao;
        private final TextView mdizhi;

        public H(View itemView) {
            super(itemView);
            mimg = itemView.findViewById(R.id.img_img);
            mjieshao = itemView.findViewById(R.id.te_jieshao);
            mdizhi= itemView.findViewById(R.id.te_dizhi);
        }
    }


}
