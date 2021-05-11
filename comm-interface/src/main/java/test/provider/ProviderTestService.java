package test.provider;

import test.bean.TestSql;

import java.util.List;

/**
 * @author tong.luo
 * @description ProviderTestService
 * @date 2021/5/11 10:22
 */
public interface ProviderTestService {
    /**
     * getTestSql
     *
     * @param testSql
     * @return
     */
    public List<TestSql> getTestSql(TestSql testSql);

    /**
     * getTestSql
     * @return
     */
    public List<TestSql> getTestSqlLimit(Integer limitbeg,Integer limitSize);
}
