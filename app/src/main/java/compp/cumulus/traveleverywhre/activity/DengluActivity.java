package compp.cumulus.traveleverywhre.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.p.Denglup;
import compp.cumulus.traveleverywhre.v.Dengluv;

public class DengluActivity extends BaseActity<Dengluv, Denglup> implements Dengluv {


    @BindView(R.id.ed_shou)
    EditText mEdShou;
    @BindView(R.id.te_yan)
    TextView mTeYan;
    @BindView(R.id.fan)
    ImageView mFan;
    @BindView(R.id.img)
    ImageView mimg;
    @BindView(R.id.re)
    RelativeLayout mRe;

    @Override
    protected Denglup initPretener() {
        return new Denglup();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_denglu;
    }

    @Override
    protected void initView() {
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mEdShou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mimg.setImageResource(R.mipmap.button_highlight);
            }
        });
        mRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mimg.setImageResource(R.mipmap.button_unavailable);
            }
        });
        mTeYan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEdShou.getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(DengluActivity.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
                    if (s.matches("^[1][3,4,5,7,8][0-9]{9}")) {
                        Toast.makeText(DengluActivity.this, "发送验证码", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DengluActivity.this, YanzhengActivity.class));
                    }else{
                        Toast.makeText(DengluActivity.this, "手机号码格式输入错误", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}
