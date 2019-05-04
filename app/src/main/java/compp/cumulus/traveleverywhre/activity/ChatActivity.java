package compp.cumulus.traveleverywhre.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.adapet.VpChatAdapet;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.fragment.MessageFragment;
import compp.cumulus.traveleverywhre.fragment.NotificationFragment;
import compp.cumulus.traveleverywhre.p.Chatp;
import compp.cumulus.traveleverywhre.v.Chatv;

public class ChatActivity extends BaseActity<Chatv, Chatp> implements Chatv {


    @BindView(R.id.ta)
    TabLayout mTa;
    @BindView(R.id.vi)
    ViewPager mVi;
    @BindView(R.id.dao)
    ImageView mDao;

    @Override
    protected Chatp initPretener() {
        return new Chatp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_chat;
    }

    @Override
    protected void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new NotificationFragment());
        fragments.add(new MessageFragment());
        ArrayList<String> list = new ArrayList<>();
        list.add("通知");
        list.add("消息");
        VpChatAdapet vpChatAdapet = new VpChatAdapet(getSupportFragmentManager(), fragments, list);
        mVi.setAdapter(vpChatAdapet);
        mTa.setupWithViewPager(mVi);
        mDao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
