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
import compp.cumulus.traveleverywhre.activity.HolldetailsActivity;
import compp.cumulus.traveleverywhre.bean.Holldetailsbean;

/**
 * Created by Lenovo on 2019/5/12.
 */

public class ReHolldetailsAdapet extends RecyclerView.Adapter {
    private  HolldetailsActivity mCon;
    private   List<Holldetailsbean.ResultBean.ReviewsBean> mlist;

    public ReHolldetailsAdapet(HolldetailsActivity holldetailsActivity, List<Holldetailsbean.ResultBean.ReviewsBean> mlist) {

        this.mCon = holldetailsActivity;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_holldetails, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        H h= (H) holder;
        h.mneirong.setText(mlist.get(position).getContent());
        h.mshijian.setText(mlist.get(position).getCreatedAt());
        h.mname.setText(mlist.get(position).getUserName());
                 //圆形
                 RequestOptions circleCropTransform =  RequestOptions.circleCropTransform();
                 Glide.with(mCon).load(mlist.get(position).getUserPhoto()).apply(circleCropTransform).into(h.mtouxiang);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    class  H extends RecyclerView.ViewHolder {

        private final ImageView mtouxiang;
        private final TextView mname;
        private final TextView mshijian;
        private final TextView mneirong;

        public H(View itemView) {
            super(itemView);
            mtouxiang = itemView.findViewById(R.id.touxiang);
            mname = itemView.findViewById(R.id.name);
            mshijian = itemView.findViewById(R.id.shijian);
            mneirong = itemView.findViewById(R.id.neirong);
        }
    }

    public void setData(List<Holldetailsbean.ResultBean.ReviewsBean> data) {
       this.mlist.addAll(data);
        notifyDataSetChanged();
    }
}
