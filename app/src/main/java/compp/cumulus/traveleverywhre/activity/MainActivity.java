package compp.cumulus.traveleverywhre.activity;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.p.Mainp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.Tools;
import compp.cumulus.traveleverywhre.v.MainV;

import static android.text.Spanned.SPAN_EXCLUSIVE_INCLUSIVE;


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
    @BindView(R.id.Protocol)
    TextView mProtocol;
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
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTeYan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEdShou.getText().length()>1){
                    Intent intent = new Intent(MainActivity.this,YanzhengActivity.class);
                    startActivity(intent);
                    Tools.closeKeyBoard(MainActivity.this);
                }

            }
        });
        mBinWb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpretener.oauth(SHARE_MEDIA.SINA);
                Log.e(TAG, "onClick: 方法" );
            }
        });
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
                    Toast.makeText(MainActivity.this, "验证码", Toast.LENGTH_SHORT).show();
                    Tools.closeKeyBoard(MainActivity.this);
                }
            }
        });


        //17个字,0-16
     /*   SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.agree_protocol));
        //SPAN_INCLUSIVE_EXCLUSIVE 1-16,插入的位置1-15 可以渲染,16就不会被渲染
        //SPAN_INCLUSIVE_INCLUSIVE 1-16,插入的位置1-16 都可以渲染
        //SPAN_EXCLUSIVE_INCLUSIVE 1-16,插入的位置2-16 都可以渲染
        spannableStringBuilder.setSpan(what,1,16, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableStringBuilder.insert(2,"12");
        mTvProtocol.setText(spannableStringBuilder);*/

        //图片混合
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getText(R.string.Bylogginginorregistering));

        //点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //跳转页面,webview展示协议
                //webView有很多坑,所以我们不直接用webView
                WebviewActivity.startAct(MainActivity.this);

            }
        };
        spannableStringBuilder.setSpan(clickableSpan,13,17,SPAN_EXCLUSIVE_INCLUSIVE);
        //下划线
        UnderlineSpan underlineSpan = new UnderlineSpan();
      spannableStringBuilder.setSpan(underlineSpan,13,17,SPAN_EXCLUSIVE_INCLUSIVE);
      //前景色
        ForegroundColorSpan what = new ForegroundColorSpan(
                getResources().getColor(R.color.c_fa6a13));
        spannableStringBuilder.setSpan(what,13,17, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //需要设置这个ClickableSpan才会有效果
        mProtocol.setMovementMethod(LinkMovementMethod.getInstance());
        mProtocol.setText(spannableStringBuilder);
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
            startActivity(new Intent(MainActivity.this,HollActivity.class));
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(MainActivity.this, "失败了：" + t.getMessage(), Toast.LENGTH_LONG).show();
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

    @Override
    public Activity getAct() {
        return MainActivity.this;
    }

    @Override
    public void go2MainActivity() {
        startActivity(new Intent(MainActivity.this,HollActivity.class));
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //内存泄漏解决方案
        UMShareAPI.get(this).release();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
