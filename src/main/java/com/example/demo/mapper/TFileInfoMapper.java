package com.example.demo.mapper;


import com.example.demo.entity.QueryInfo;
import com.example.demo.entity.TFileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TFileInfoMapper {
	
    int deleteByPrimaryKey(@Param("id")String id);

    int insert(@Param("record")TFileInfo record);

    int insertSelective(@Param("record") TFileInfo record);

    TFileInfo selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(@Param("record") TFileInfo record);

    int updateByPrimaryKey(@Param("record")  TFileInfo record);

	List<TFileInfo> selectFileByParams(@Param("record") TFileInfo fileInfo);
	
	List<TFileInfo> selectFileList(@Param("record") QueryInfo query);

}