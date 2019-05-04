package compp.cumulus.traveleverywhre.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import compp.cumulus.traveleverywhre.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_message, container, false);
        return inflate;
    }

}
