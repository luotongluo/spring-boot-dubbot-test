package test.manage;

import test.bean.TestSql;

/**
 * @author tong.luo
 * @description ManageTestServicce
 * @date 2021/5/11 10:22
 */
public interface ManageTestServicce {
    /**
     * insertTest
     * @param testSql
     * @return
     */
    public TestSql insertTest(TestSql testSql);
}
