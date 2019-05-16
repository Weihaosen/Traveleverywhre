package compp.cumulus.traveleverywhre.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.p.Upnamep;
import compp.cumulus.traveleverywhre.v.Upnamev;

public class UpnameActivity extends BaseActity<Upnamev, Upnamep> implements Upnamev {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.to)
    Toolbar mTo;
    @BindView(R.id.ed_neirong)
    EditText mEdNeirong;
    @BindView(R.id.te_wancheng)
    TextView mTeWancheng;
    @BindView(R.id.shuzi)
    TextView mShuzi;
    private String mname;
    private String ms;


    @Override
    protected Upnamep initPretener() {
        return new Upnamep();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_upname;
    }

    @Override
    protected void initView() {
        mTo.setTitle("");
        setSupportActionBar(mTo);
    }

    @Override
    protected void initData() {
        mname = getIntent().getStringExtra("name");
        mEdNeirong.setText(mname);
        mShuzi.setText((27-mEdNeirong.getText().toString().length())+"/27");
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTeWancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ms = mEdNeirong.getText().toString().trim();
                Log.e("UpnameActivity", "initData: " + ms);
                Intent intent = new Intent(UpnameActivity.this, PersonalActivity.class);
                intent.putExtra("mingzi", ms);
                Log.e("UpnameActivity", "onClick: " + ms);
                setResult(333, intent);
                finish();
            }
        });
    }

}
