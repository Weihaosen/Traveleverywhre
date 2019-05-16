package compp.cumulus.traveleverywhre.adapet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.activity.CollectActivity;
import compp.cumulus.traveleverywhre.bean.Circuitfragmentbean;
import compp.cumulus.traveleverywhre.bean.Collectbean;

/**
 * Created by Lenovo on 2019/5/12.
 */

public class ReCircuitfraggmentAdapet extends RecyclerView.Adapter {


    private  Context mCon;
    private  List<Circuitfragmentbean.ResultBean.RoutesBean> mlist;

    public ReCircuitfraggmentAdapet(Context context, List<Circuitfragmentbean.ResultBean.RoutesBean> mlist) {
        this.mCon = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_circuitfragment, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        H h= (H) holder;
        h.tv_city.setText(mlist.get(position).getCity());
        h.tv_title.setText(mlist.get(position).getTitle());
        h.tv_intro.setText(mlist.get(position).getIntro());
        h.tv_purchasedTimes.setText("294人购买");
        Glide.with(mCon).load(mlist.get(position).getCardURL()).into(h.img_background);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<Circuitfragmentbean.ResultBean.RoutesBean> data) {
        this.mlist.addAll(data);
        notifyDataSetChanged();
    }


    class  H extends RecyclerView.ViewHolder {

        private ImageView img_background;
        private TextView tv_title;
        private TextView tv_city;
        private TextView tv_intro;
        private TextView tv_purchasedTimes;

        public H(View itemView) {
            super(itemView);
            img_background = itemView.findViewById(R.id.img_background);
            tv_city = itemView.findViewById(R.id.tv_city);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_intro = itemView.findViewById(R.id.tv_intro);
            tv_purchasedTimes = itemView.findViewById(R.id.tv_purchasedTimes);
        }
    }


}
