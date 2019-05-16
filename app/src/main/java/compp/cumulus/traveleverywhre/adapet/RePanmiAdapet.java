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
import compp.cumulus.traveleverywhre.bean.Panmibean;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.ToastUtil;

/**
 * Created by Lenovo on 2019/5/6.
 */

public class RePanmiAdapet extends RecyclerView.Adapter {

    private final Context mCon;
    private final List<Panmibean.ResultBean.BanmiBean> mlist;
    private boolean a=false;
    private OnItemClickListener mListener;

    public RePanmiAdapet(Context context, List<Panmibean.ResultBean.BanmiBean> mlist) {

        this.mCon = context;
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
           final H h = (H) holder;
          h.mdizhi.setText(mlist.get(position).getLocation());
          h.mguanzhu.setText(mlist.get(position).getFollowing()+"关注");
          h.mmingzi.setText(mlist.get(position).getName());
          h.mzuozhe.setText(mlist.get(position).getOccupation());
        Glide.with(mCon).load(mlist.get(position).getPhoto()).into(h.mtu);
        if(mlist.get(position).isIsFollowed()){
        h.mxin.setBackgroundResource(R.drawable.follow);
        }else{
        h.mxin.setBackgroundResource(R.drawable.follow_unselected);
        }
        h.mxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==false){
                    if(onFollowCliclListener!=null){
                        onFollowCliclListener.Follow(mlist.get(position).getId());
                        Logger.logD("","sfdgfgbn"+mlist.get(position).getId());
                        h.mxin.setBackgroundResource(R.drawable.follow);
                        h.mguanzhu.setText(mlist.get(position).getFollowing()+1+"人关注");
                        mlist.get(position).setIsFollowed(true);
                        a=true;
                    }
                }else if(a==true){
                    if (onFollowCliclListener!=null){
                        onFollowCliclListener.unFollow(mlist.get(position).getId());
                        h.mxin.setBackgroundResource(R.drawable.follow_unselected);
                        h.mguanzhu.setText(mlist.get(position).getFollowing()-1+"人关注");
                        mlist.get(position).setIsFollowed(false);
                        a=false;
                    }
                }
            }
        });

        h.mtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.OnItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<Panmibean.ResultBean.BanmiBean> data) {
        this.mlist.addAll(data) ;
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

    private   OnFollowCliclListener onFollowCliclListener;
    public void setOnFollowCliclListener(OnFollowCliclListener onFollowCliclListener) {
        this.onFollowCliclListener=onFollowCliclListener;
    }
    public  interface  OnFollowCliclListener{
        void unFollow(int id);
        void  Follow(int id);

    }
      public interface OnItemClickListener
               {
                   void OnItemClick(View v,int position );
               }
               public void setOnItemClickListener(OnItemClickListener listener)
               {
                   this.mListener=listener;
               }
}
