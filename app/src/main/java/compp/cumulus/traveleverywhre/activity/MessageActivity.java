package compp.cumulus.traveleverywhre.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.BaseActity;
import compp.cumulus.traveleverywhre.p.Messagep;
import compp.cumulus.traveleverywhre.v.Messagev;

public class MessageActivity extends BaseActity<Messagev,Messagep> implements Messagev {


    @Override
    protected Messagep initPretener() {
        return new Messagep();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }
}
