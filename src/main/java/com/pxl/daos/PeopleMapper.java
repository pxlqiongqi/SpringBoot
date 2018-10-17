package com.pxl.daos;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pxl.pojos.People;
import com.pxl.pojos.PeopleQuery;
public interface PeopleMapper {
    int countByExample(PeopleQuery example);

    int deleteByExample(PeopleQuery example);

    int deleteByPrimaryKey(Integer id);
    
    int insert(People record);

    int insertSelective(People record);

    List<People> selectByExample(PeopleQuery example);

    People selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") People record, @Param("example") PeopleQuery example);

    int updateByExample(@Param("record") People record, @Param("example") PeopleQuery example);

    int updateByPrimaryKeySelective(People record);

    int updateByPrimaryKey(People record);
}