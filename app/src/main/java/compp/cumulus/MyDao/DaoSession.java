package compp.cumulus.MyDao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import compp.cumulus.traveleverywhre.Sql.Mydb;

import compp.cumulus.MyDao.MydbDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig mydbDaoConfig;

    private final MydbDao mydbDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        mydbDaoConfig = daoConfigMap.get(MydbDao.class).clone();
        mydbDaoConfig.initIdentityScope(type);

        mydbDao = new MydbDao(mydbDaoConfig, this);

        registerDao(Mydb.class, mydbDao);
    }
    
    public void clear() {
        mydbDaoConfig.clearIdentityScope();
    }

    public MydbDao getMydbDao() {
        return mydbDao;
    }

}
