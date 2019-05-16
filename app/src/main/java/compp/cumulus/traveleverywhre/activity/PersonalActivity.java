package compp.cumulus.traveleverywhre.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import butterknife.BindView;
import butterknife.OnClick;
import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.bean.personalbean;
import compp.cumulus.traveleverywhre.p.Personalp;
import compp.cumulus.traveleverywhre.util.Logger;
import compp.cumulus.traveleverywhre.util.SpUtil;
import compp.cumulus.traveleverywhre.v.Personalv;

public class PersonalActivity extends BaseActity<Personalv, Personalp> implements Personalv {

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.mingzi)
    TextView mMingzi;
    @BindView(R.id.xingbie)
    TextView mXingbie;
    @BindView(R.id.qianming)
    TextView mQianming;
    @BindView(R.id.tesc)
    TextView mTesc;
    @BindView(R.id.ome)
    LinearLayout mome;
    @BindView(R.id.two)
    LinearLayout mTwo;
    @BindView(R.id.ser)
    LinearLayout mSer;
    @BindView(R.id.forg)
    LinearLayout mForg;
    @BindView(R.id.teste)
    TextView mTeste;
    private personalbean.ResultBean mresult;
    private PopupWindow mPopupWindow2;
    private String mnan;
    private static final int NAME = 300;
    private static final int QIANMING = 500;
    private static final int TOUXIANG = 100;
    private static final String TAG = PersonalActivity.class.getName();


    @Override
    protected Personalp initPretener() {
        return new Personalp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal;
    }


    @Override
    protected void initData() {
        showLoading();
        String token = (String) SpUtil.getParam(Constants.TOKEN, "");
        mpretener.setinfo(token);
    }

    @OnClick({R.id.ome, R.id.two, R.id.ser, R.id.forg})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ome:
                touxiang();
                break;
            case R.id.two:
                Intent intent = new Intent(this, UpnameActivity.class);
                intent.putExtra("name", mresult.getUserName());
                startActivityForResult(intent,NAME);
                break;
            case R.id.ser:
                iniPopXingbie();
                break;
            case R.id.forg:
                Intent intentDecr = new Intent(this, UpsignatureActivity.class);
                intentDecr.putExtra("neirong", mresult.getDescription());
                startActivityForResult(intentDecr, QIANMING);
                break;
        }
    }

    private void touxiang() {
        Intent intent = new Intent(PersonalActivity.this, UpheadportraitActivity.class);
        intent.putExtra("img",mresult.getPhoto());
        startActivityForResult(intent,TOUXIANG);
    }


    private void iniPopXingbie() {
        mPopupWindow2 = new PopupWindow();
        final View inflate2 = LayoutInflater.from(this).inflate(R.layout.pop2, null, false);
        mPopupWindow2.setContentView(inflate2);
        mPopupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow2.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow2.setBackgroundDrawable(new ColorDrawable());
        mPopupWindow2.setOutsideTouchable(true);
        mPopupWindow2.showAsDropDown(mImg, Gravity.BOTTOM,1000,1000);
        inflate2.findViewById(R.id.nan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mnan = "男";
                SpUtil.setParam(Constants.XINGBIE,mnan);
                mXingbie.setText(mnan);
                mPopupWindow2.dismiss();

            }
        });
        inflate2.findViewById(R.id.nv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nv="女";
                SpUtil.setParam(Constants.XINGBIE,nv);
                mXingbie.setText(nv);
                mPopupWindow2.dismiss();

            }
        });
        inflate2.findViewById(R.id.renyao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String renya="人妖";
                SpUtil.setParam(Constants.XINGBIE,renya);
                mXingbie.setText(renya);
                mPopupWindow2.dismiss();
            }
        });
        inflate2.findViewById(R.id.qu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow2.dismiss();
            }
        });
        mPopupWindow2.showAtLocation(mImg, Gravity.CENTER, 0, 0);
    }
    @Override
    public void setInfo(String bean) {
        Gson gson = new Gson();
        personalbean personalbean = gson.fromJson(bean, personalbean.class);
        if (personalbean != null && personalbean.getResult() != null) {
            mresult = personalbean.getResult();
            Logger.logD("setInfo", "" + mresult);
            if (mresult != null) {
                SpUtil.setParam(Constants.TOUXIANG, mresult.getPhoto());
                Glide.with(this).load(mresult.getPhoto()).into(mImg);
                String name = (String) SpUtil.getParam(Constants.MINGZI, mresult.getUserName());
                mMingzi.setText(name);
                String qianming = (String) SpUtil.getParam(Constants.QIANMING, mresult.getDescription());
                mQianming.setText(qianming);
                String xingbie = (String) SpUtil.getParam(Constants.XINGBIE, mresult.getGender());
                mXingbie.setText(xingbie);
            }
        }
        hideLoading();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==NAME&&resultCode==333){
            String mingzi = data.getStringExtra("mingzi");
            SpUtil.setParam(Constants.MINGZI,mingzi);
            mMingzi.setText(mingzi);
        }
        if(requestCode==QIANMING&&resultCode==555){
            String gexingqianming = data.getStringExtra("gexingqianming");
            SpUtil.setParam(Constants.QIANMING,gexingqianming);
            mQianming.setText(gexingqianming);
        }

    }
}
