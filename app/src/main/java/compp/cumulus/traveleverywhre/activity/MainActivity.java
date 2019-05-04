package compp.cumulus.traveleverywhre.activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
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
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.fragment.MainFragment;
import compp.cumulus.traveleverywhre.p.Mainp;
import compp.cumulus.traveleverywhre.v.MainV;


public class MainActivity extends BaseActity<MainV, Mainp> implements MainV {

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
    @BindView(R.id.img)
    ImageView mimg;
    @Override
    protected Mainp initPretener() {
        return new Mainp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }



    @Override
    protected void initView() {
        mBinQq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(SHARE_MEDIA.QQ);
            }
        });

        mEdShou.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                switchBtnState(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = s.length();
                if(length==11){
                           startActivity(new Intent(MainActivity.this,YanzhengActivity.class));
                }
            }
        });
    }


        private void switchBtnState(CharSequence s) {
            if(TextUtils.isEmpty(s)){
                mimg.setBackgroundResource(R.drawable.btn_ea_r15);
            }else{
                mimg.setBackgroundResource(R.drawable.btn_ea_fa6a13_r15);
            }

        }



    private void login(SHARE_MEDIA type) {
        UMShareAPI umShareAPI = UMShareAPI.get(MainActivity.this);
        umShareAPI.getPlatformInfo(MainActivity.this, type, umAuthListener);
    }

    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Log.d(TAG, "key: " + key + ",value:" + value);
            }
            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this,DengluActivity.class));
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(MainActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

}
