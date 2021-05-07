package test.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tong.luo
 * @description TestVo
 * @date 2021/5/7 15:03
 */
public class TestVo implements Serializable {
    private static final long serialVersionUID = 6337315616643599667L;
    /**
     * name
     */
    private String name;
    /**
     * age
     */
    private Integer age;
    /**
     * birthday
     */
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
