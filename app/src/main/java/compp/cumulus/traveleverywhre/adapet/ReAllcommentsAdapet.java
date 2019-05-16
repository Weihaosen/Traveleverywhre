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
import compp.cumulus.traveleverywhre.activity.AllcommentsActivity;
import compp.cumulus.traveleverywhre.activity.CollectActivity;
import compp.cumulus.traveleverywhre.bean.Allcommentsbean;
import compp.cumulus.traveleverywhre.bean.Collectbean;

/**
 * Created by Lenovo on 2019/5/12.
 */

public class ReAllcommentsAdapet extends RecyclerView.Adapter {
    private  AllcommentsActivity mCon;
    private  List<Allcommentsbean.ResultBean.ReviewsBean> mlist;


    public ReAllcommentsAdapet(AllcommentsActivity allcommentsActivity, List<Allcommentsbean.ResultBean.ReviewsBean> mlist) {

        this.mCon = allcommentsActivity;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_allcomments, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        H h= (H) holder;
        h.mshijian.setText(mlist.get(position).getCreatedAt());
        h.mneirong.setText(mlist.get(position).getContent());
        h.mmingzi.setText(mlist.get(position).getUserName());
        Glide.with(mCon).load(mlist.get(position).getUserPhoto()).into(h.mtouxiang);

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<Allcommentsbean.ResultBean.ReviewsBean> data) {
        this.mlist.addAll(data);
        notifyDataSetChanged();
    }


    class  H extends RecyclerView.ViewHolder {

        private  ImageView mtouxiang;
        private  TextView mmingzi;
        private  TextView mshijian;
        private  TextView mneirong;

        public H(View itemView) {
            super(itemView);
            mtouxiang = itemView.findViewById(R.id.img_touxiang);
            mshijian = itemView.findViewById(R.id.text_shijian);
           mneirong= itemView.findViewById(R.id.text_neirong);
            mmingzi= itemView.findViewById(R.id.text_mingzi);
        }
    }


}
