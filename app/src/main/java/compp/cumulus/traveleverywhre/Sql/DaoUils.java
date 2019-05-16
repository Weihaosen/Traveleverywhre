package compp.cumulus.traveleverywhre.Sql;

import java.util.List;

import compp.cumulus.MyDao.DaoMaster;
import compp.cumulus.MyDao.DaoSession;
import compp.cumulus.MyDao.MydbDao;
import compp.cumulus.traveleverywhre.base.BaseApp;

/**
 * Created by Lenovo on 2019/5/10.
 */

public class DaoUils {
    public static DaoUils DaoUils;
    private MydbDao mydbDao;

              public DaoUils() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Myapp.myapp, "Whs.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        mydbDao = daoSession.getMydbDao();
    }
    public static DaoUils getInstance(){
        if(DaoUils==null){
            //多线程访问，安全处理
            synchronized (DaoUils.class){
                if(DaoUils==null){
                    DaoUils=new DaoUils();
                }
            }
        }
        return DaoUils;
    }
    public void insert(List<Mydb> list){
        mydbDao.insertInTx(list);
    }
    public List<Mydb> select(){

        return mydbDao.loadAll();
    }
    public void delete(Mydb mydb){
        mydbDao.delete(mydb);
    }
    public void updata(Mydb myDb){
        mydbDao.update(myDb);
    }
    public boolean has(Mydb mydb){
        List<Mydb> list = mydbDao.queryBuilder().where(MydbDao.Properties.Name.eq(mydb.name)).list();
        if (list!=null && list.size()>0){
            return true;
        }
        return false;
    }

    public void insert_one(Mydb mydb){
        if ( has(mydb)){
            return;
        }
        mydbDao.insertOrReplace(mydb);

    }
}
