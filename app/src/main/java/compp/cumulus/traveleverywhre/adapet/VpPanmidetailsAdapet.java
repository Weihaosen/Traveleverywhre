package compp.cumulus.traveleverywhre.adapet;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2019/5/14.
 */

public class VpPanmidetailsAdapet extends FragmentStatePagerAdapter {
    private final ArrayList<String> list;
    private final ArrayList<Fragment> fragments;

    public VpPanmidetailsAdapet(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> fragments) {
        super(fm);
        this.list = list;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
