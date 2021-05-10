package com.lt.dubboprovidermanage.test.data2.mapper;

import com.lt.dubboprovidermanage.entity.TestSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试表(TestSql)表数据库访问层
 *
 * @author tong.luo
 * @since 2021-05-07 20:04:30
 */
@Mapper
public interface TestData2SqlMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestSql queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TestSql> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param testSql 实例对象
     * @return 对象列表
     */
    List<TestSql> queryAll(TestSql testSql);

    /**
     * 新增数据
     *
     * @param testSql 实例对象
     * @return 影响行数
     */
    int insert(TestSql testSql);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TestSql> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TestSql> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TestSql> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TestSql> entities);

    /**
     * 修改数据
     *
     * @param testSql 实例对象
     * @return 影响行数
     */
    int update(TestSql testSql);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

