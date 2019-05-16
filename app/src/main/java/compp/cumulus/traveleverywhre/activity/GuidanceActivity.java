package compp.cumulus.traveleverywhre.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.p.Guidancep;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Guidancev;
import compp.cumulus.traveleverywhre.widget.PreviewIndicator;

public class GuidanceActivity extends BaseActity<Guidancev, Guidancep> implements Guidancev {


    @BindView(R.id.vi)
    ViewPager mVi;
    @BindView(R.id.indicator)
    PreviewIndicator mIndicator;
    @BindView(R.id.btn_tiao)
    Button mBtnTiao;


    @Override
    protected Guidancep initPretener() {
        return new Guidancep();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_guidance;
    }

    @Override
    protected void initView() {
        mIndicator.initSize(80,32,6);
        mIndicator.setNumbers(3);
        final ArrayList<View> list = new ArrayList<>();
        View ont = LayoutInflater.from(this).inflate(R.layout.item_guiont, null, false);
        View two = LayoutInflater.from(this).inflate(R.layout.item_guitwo, null, false);
        View seten = LayoutInflater.from(this).inflate(R.layout.item_guiseten, null, false);
        list.add(ont);
        list.add(two);
        list.add(seten);



        mVi.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(list.get(position % list.size()));
                return list.get(position % list.size());
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(list.get(position % list.size()));
            }
        });


            mVi.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mIndicator.setSelected(position);
                if (position ==2) {
                    mIndicator.setVisibility(View.GONE);
                    mBtnTiao.setVisibility(View.VISIBLE);
                } else {
                    mIndicator.setVisibility(View.VISIBLE);
                    mBtnTiao.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    protected void initListener() {
        mBtnTiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(GuidanceActivity.this,MainActivity.class));
                    finish();
            }
        });
    }


}
