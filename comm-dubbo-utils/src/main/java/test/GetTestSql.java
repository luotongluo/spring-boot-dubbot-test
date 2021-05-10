package test;

import java.util.Date;
import java.util.UUID;

/**
 * @author tong.luo
 * @description GetTestSql
 * @date 2021/5/10 15:59
 */
public class GetTestSql {
    public static TestSql getTestSql() {
        TestSql testSql = new TestSql();
        testSql.setId(String.valueOf(System.nanoTime()));
        testSql.setUserName(UUID.randomUUID().toString());
        testSql.setUserAge((int) (Math.random() * 100));
        Date date = new Date();
        testSql.setUserBirthday(date);
        testSql.setDeleteInfo(0);
        testSql.setCreateTime(date);
        testSql.setUpdateTime(date);
        testSql.setBackup1("");
        testSql.setBackup2("");
        return testSql;
    }
}
