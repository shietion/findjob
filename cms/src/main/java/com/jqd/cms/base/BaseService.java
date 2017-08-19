package com.jqd.cms.base;

import java.util.List;


/**
 * 
 * @author dujianqiao
 * <p>desc</p>
 * @version 1.1
 * @date 2017年7月29日 上午11:02:54
 * @param <Record>
 */

public interface BaseService<Record> {


    int deleteByPrimaryKey(Long id);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(Record example);

    Record selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Record record);


    int updateByPrimaryKey(Record record);

    int deleteByPrimaryKeys(String ids);

    void initMapper();

}