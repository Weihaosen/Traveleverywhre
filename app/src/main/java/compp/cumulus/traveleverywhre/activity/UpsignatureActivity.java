package compp.cumulus.traveleverywhre.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.p.Upsignaturep;
import compp.cumulus.traveleverywhre.v.Upsignaturev;

public class UpsignatureActivity extends BaseActity<Upsignaturev, Upsignaturep> implements Upsignaturev {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.te_wancheng)
    TextView mTeWancheng;
    @BindView(R.id.to)
    Toolbar mTo;
    @BindView(R.id.ed_neirong)
    EditText mEdNeirong;
    @BindView(R.id.shuzi)
    TextView mShuzi;
    private String mtrim;

    @Override
    protected Upsignaturep initPretener() {
        return new Upsignaturep();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_upsignature;
    }

    @Override
    protected void initView() {
        mTo.setTitle("");
        setSupportActionBar(mTo);

    }

    @Override
    protected void initData() {
        String neirong = getIntent().getStringExtra("neirong");
        mEdNeirong.setText(neirong);
        mShuzi.setText((27-mEdNeirong.getText().toString().length())+"/27");
    }

    @Override
    protected void initListener() {
        mTeWancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtrim = mEdNeirong.getText().toString().trim();
                Intent intent = new Intent(UpsignatureActivity.this, PersonalActivity.class);
                intent.putExtra("gexingqianming", mtrim);
                setResult(555, intent);
                finish();
            }
        });
    }

    @OnClick({R.id.back, R.id.te_wancheng, R.id.to, R.id.ed_neirong})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                mBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
        }
    }

}
