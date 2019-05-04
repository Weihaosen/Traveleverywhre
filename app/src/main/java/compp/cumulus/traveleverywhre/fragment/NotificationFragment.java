package compp.cumulus.traveleverywhre.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import compp.cumulus.traveleverywhre.R;
import compp.cumulus.traveleverywhre.base.Basefragment;
import compp.cumulus.traveleverywhre.p.Notificationp;
import compp.cumulus.traveleverywhre.v.Notoficationv;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Basefragment<Notoficationv,Notificationp> implements Notoficationv{



    @Override
    protected Notificationp initPretener() {
        return new Notificationp();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_notification;
    }
}
