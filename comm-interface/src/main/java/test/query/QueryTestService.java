package test.query;

import test.bean.TestSql;

import java.util.List;

/**
 * @author tong.luo
 * @description QueryTestService
 * @date 2021/5/11 10:23
 */
public interface QueryTestService {
    /**
     * getTestSql
     *
     * @param testSql
     * @return
     */
    public List<TestSql> getTestSql(TestSql testSql);

    /**
     * getTestSql
     * @param limitbeg
     * @param limitSize
     * @return
     */
    public List<TestSql> getTestSql(Integer limitbeg,Integer limitSize);
}
