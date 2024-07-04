package com.example.demo.mapper;

import com.example.demo.entity.TChunkInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface TChunkInfoMapper {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(@Param("record")TChunkInfo record);

    int insertSelective(@Param("record")TChunkInfo record);

    TChunkInfo selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(@Param("record")TChunkInfo record);

    int updateByPrimaryKey(@Param("record")TChunkInfo record);
    
    ArrayList<Integer> selectChunkNumbers(@Param("record") TChunkInfo record);
}