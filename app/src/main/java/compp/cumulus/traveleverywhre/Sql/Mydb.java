package compp.cumulus.traveleverywhre.Sql;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Lenovo on 2019/5/10.
 */
@Entity
public class Mydb  {
    @Id(autoincrement =true)
    Long  id;
    String name;
    String img;
    String biao;
    @Generated(hash = 590715589)
    public Mydb(Long id, String name, String img, String biao) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.biao = biao;
    }
    @Generated(hash = 188192501)
    public Mydb() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getBiao() {
        return this.biao;
    }
    public void setBiao(String biao) {
        this.biao = biao;
    }

}
