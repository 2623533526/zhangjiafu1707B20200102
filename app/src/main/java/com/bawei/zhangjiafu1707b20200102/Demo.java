package com.bawei.zhangjiafu1707b20200102;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: 张家辅
 * @date: 2020/01/02
 */
@Entity
public class Demo {
    @Id(autoincrement = true)
    private Long id;
    private String string;
    @Generated(hash = 1610232588)
    public Demo(Long id, String string) {
        this.id = id;
        this.string = string;
    }
    @Generated(hash = 571290164)
    public Demo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getString() {
        return this.string;
    }
    public void setString(String string) {
        this.string = string;
    }

}
