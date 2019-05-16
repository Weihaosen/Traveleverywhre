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
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.Hollbean;
import compp.cumulus.traveleverywhre.util.Logger;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2019/5/6.
 */

public class ReHolladapet extends RecyclerView.Adapter {
    private final List<Hollbean.ResultBean.BannersBean> mBannersList;
    private final List<Hollbean.ResultBean.RoutesBean> mArticleList;
    private Context mContext;
    private OnItemClickListener mListener;
    private OnItemClickListener mYishuListener;

    public ReHolladapet(Context context, List<Hollbean.ResultBean.BannersBean> mban, List<Hollbean.ResultBean.RoutesBean> mlist) {

        this.mContext = context;
        this.mBannersList = mban;
        this.mArticleList = mlist;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_banner, null, false);
            return new BannerViewHolder(inflate);
        }else if (viewType==1){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_holl, null, false);
            return new ArticleViewHolder(inflate);
        } else{
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_yishu, null, false);
            return new YiH(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0){
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.mBanner.setImages(mBannersList);
            bannerViewHolder.mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Hollbean.ResultBean.BannersBean bean = (Hollbean.ResultBean.BannersBean) path;
                    Glide.with(mContext).load(bean.getImageURL()).into(imageView);
                }
            }).start();
        }else if(itemViewType==1) {
            int newsPosition  =position;
            if (mBannersList.size()>0&&mArticleList.size()>6){
                newsPosition = position - 1;
            }
            ArticleViewHolder holder1 = (ArticleViewHolder) holder;
            Hollbean.ResultBean.RoutesBean bean = mArticleList.get(newsPosition);
            holder1.tv_city.setText(bean.getCity());
            holder1.tv_title.setText(bean.getTitle());
            holder1.tv_intro.setText(bean.getIntro());
            holder1.tv_purchasedTimes.setText(bean.getPurchasedTimes()+"人购买");
            Glide.with(mContext).load(bean.getCardURL()).into(holder1.img_background);
            boolean isPurchased = bean.isIsPurchased();
            if (isPurchased){
                holder1.btn_isPurchased.setBackgroundResource(R.drawable.bg_eaeaea_r6);
                holder1.btn_isPurchased.setText("已购买");
            }
            final int mPosition = newsPosition;
            holder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        mListener.OnItemClick(v,mPosition);
                    }
                }
            });

        }else if (itemViewType==2){
            int newsPosition = position;
            if (mBannersList.size()>0){
                newsPosition = position - 1;
            }

            YiH h= (YiH) holder;
            Glide.with(mContext).load(mArticleList.get(newsPosition).getCardURL()).into(h.mimgtu);
        }


    }

    @Override
    public int getItemCount() {
        if (mBannersList.size()>0){
            return mArticleList.size()+1;
        }else {
            return mArticleList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        int index = 0;
        if (position == 0){
            index= 0;
        }else {
            int newsposition = position;
            if (mBannersList.size()>0){
                newsposition = position-1;
                if (mArticleList.get(newsposition).getType().equals(Constants.ROUTE)){
                    index =  1;
                }else {
                    index =  2;
                }
            }

        }
        return index;
    }

    public void setDatalist(List<Hollbean.ResultBean.RoutesBean> datalist) {
        this.mArticleList.addAll(datalist);
        notifyDataSetChanged();
    }

    public void setDataBanner(List<Hollbean.ResultBean.BannersBean> dataBanner) {
      this.mBannersList.addAll(dataBanner);
      notifyDataSetChanged();
    }


    class BannerViewHolder extends RecyclerView.ViewHolder {

        private Banner mBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.banner);
        }
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_background;
        private TextView tv_title;
        private TextView tv_city;
        private TextView tv_intro;
        private TextView tv_purchasedTimes;
        private Button btn_isPurchased;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            img_background = itemView.findViewById(R.id.img_background);
            tv_city = itemView.findViewById(R.id.tv_city);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_intro = itemView.findViewById(R.id.tv_intro);
            tv_purchasedTimes = itemView.findViewById(R.id.tv_purchasedTimes);
            btn_isPurchased = itemView.findViewById(R.id.btn_isPurchased);
        }
    }
    class YiH extends RecyclerView.ViewHolder {

        private ImageView mimgtu;

        public YiH(View itemView) {
            super(itemView);
            mimgtu = itemView.findViewById(R.id.img_tu);
        }
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

