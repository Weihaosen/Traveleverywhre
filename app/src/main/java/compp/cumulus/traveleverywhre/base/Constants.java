package compp.cumulus.traveleverywhre.base;
import android.os.Environment;
import java.io.File;
import java.security.Key;

/**
 * Created by Lenovo on 2019/4/17.
 */

public interface Constants {
    boolean isDebug = true;


    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "codeest" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApp.getInstance().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
    String DATA = "data";
    //夜间模式
    String MODE = "mode";
    String NIGHT_CURRENT_FRAG_POS = "fragment_pos";


    String TOKEN = "token";
    String DESC = "description";
    String USERNAME = "userName";
    String GENDER = "gender";
    String EMAIL = "email";
    String PHOTO = "photo";
    String PHONE = "phone";
    String MINGZI = "mingzi";
    String QIANMING = "qianming";
    String XINGBIE = "xingbie";
    String TOUXIANG = "touxiang";
    String START = "start";
    String ROUTE = "route";
    String GUANZHU ="guanzhu";
    String SHOUCANG ="shoucang";

}
