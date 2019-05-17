package compp.cumulus.traveleverywhre.activity;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

import compp.cumulus.traveleverywhre.base.Constants;
import compp.cumulus.traveleverywhre.util.SpUtil;

/**
 * Created by Lenovo on 2019/5/16.
 */

public class Androidjs extends Object{

    private Context mCon;

    public Androidjs(Context context) {

        this.mCon = context;
    }
    @JavascriptInterface
    public void callAndroid(String type,int id) {
        if (type.equals("route_details")){
            SpUtil.setParam(Constants.PATH_ID,id);
            mCon.startActivity(new Intent(mCon,HolldetailsActivity.class));

        }
    }


    @JavascriptInterface
    public void callAndroid(String type) {
        if (type.equals("subject_list")){
            mCon.startActivity(new Intent(mCon,ThemeActivity.class));
        }
    }
}
