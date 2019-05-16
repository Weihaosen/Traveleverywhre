package compp.cumulus.traveleverywhre.v;

import compp.cumulus.traveleverywhre.base.BaseView;
import compp.cumulus.traveleverywhre.bean.Panmibean;

/**
 * Created by Lenovo on 2019/4/30.
 */

public interface Panmiv extends BaseView {
    void setData(Panmibean bean);

    void getPanmifragmentunData(String bean);

    void getPanmifragmentData(String bean);
}
