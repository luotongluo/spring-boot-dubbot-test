package com.lt.dubboproviderquery.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 测试表(TestSql)实体类
 *
 * @author tong.luo
 * @since 2021-05-07 20:04:27
 */
public class TestSql implements Serializable {
    private static final long serialVersionUID = -86166827185754893L;
    /**
     * 测试表id
     */
    private String id;
    /**
     * user_name
     */
    private String userName;
    /**
     * user_age
     */
    private Integer userAge;
    /**
     * user_birthday
     */
    private Date userBirthday;
    /**
     * 0未删除，1已删除
     */
    private Integer deleteInfo;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 备用字段1
     */
    private String backup1;
    /**
     * 备用字段2
     */
    private String backup2;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getDeleteInfo() {
        return deleteInfo;
    }

    public void setDeleteInfo(Integer deleteInfo) {
        this.deleteInfo = deleteInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1;
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2;
    }

}
