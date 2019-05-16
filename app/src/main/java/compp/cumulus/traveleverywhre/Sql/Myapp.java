package compp.cumulus.traveleverywhre.Sql;

import android.app.Application;

/**
 * Created by Lenovo on 2019/5/10.
 */

public class Myapp  extends Application{
    public static Myapp myapp;
    public void setData(){}

    @Override
    public void onCreate() {
        super.onCreate();
        myapp=this;
    }
}
