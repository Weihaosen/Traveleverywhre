package compp.cumulus.traveleverywhre.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.activity.DengluActivity;
import compp.cumulus.traveleverywhre.activity.MainActivity;
import compp.cumulus.traveleverywhre.activity.YanzhengActivity;
import compp.cumulus.traveleverywhre.base.Basefragment;
import compp.cumulus.traveleverywhre.p.Mainfragmentp;
import compp.cumulus.traveleverywhre.v.Mainfragmentv;
import retrofit2.http.GET;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Basefragment<Mainfragmentv,Mainfragmentp> implements Mainfragmentv {

    private static final String TAG = "MainActivity";
    @BindView(R.id.bin_wechat)
    ImageView mBinWechat;
    @BindView(R.id.bin_qq)
    ImageView mBinQq;
    @BindView(R.id.bin_wb)
    ImageView mBinWb;
    @BindView(R.id.ed_shou)
    EditText mEdShou;
    @BindView(R.id.te_yan)
    TextView mTeYan;
    @BindView(R.id.re)
    RelativeLayout mRe;
    @BindView(R.id.img)
    ImageView mimg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);
        return inflate;
    }

    @Override
    protected Mainfragmentp initPretener() {
        return new Mainfragmentp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }
    @Override
    protected void initListener() {

    }


}
