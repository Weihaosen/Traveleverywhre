package compp.cumulus.traveleverywhre.adapet;

import android.content.Context;
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
import compp.cumulus.traveleverywhre.bean.Panmidetailsbean;

/**
 * Created by Lenovo on 2019/5/14.
 */

public class ReXiaoDynamicAdapet extends RecyclerView.Adapter{


    private  Context mCon;
    private  List<String> mlist;


    public ReXiaoDynamicAdapet(Context mCon, List<String> mlist) {
        this.mCon = mCon;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_xiaodynamic, null, false);
        return new H(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        H h = (H) holder;
        Glide.with(mCon).load(mlist.get(position)).into(h.mimg);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<String> data) {
        this.mlist.addAll(data);
        notifyDataSetChanged();
    }


    class  H extends RecyclerView.ViewHolder {
        private  ImageView mimg;

        public H(View itemView) {
            super(itemView);
            mimg = itemView.findViewById(R.id.img);
        }
    }
}
