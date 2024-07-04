package com.example.demo.service;

import com.example.demo.entity.QueryInfo;
import com.example.demo.entity.TFileInfo;

import java.util.List;

public interface FileInfoService {
	
	public int addFileInfo(TFileInfo fileInfo);
	
	public List<TFileInfo> selectFileByParams(TFileInfo fileInfo);
	
	 /**
     * 查询
     *
     * @param query 查询条件
     * @return List
     */
    List<TFileInfo> selectFileList(QueryInfo query);
                    
    
    /**
     * 删除
     * @param tFileInfo
     * @return
     */
    int deleteFile(TFileInfo tFileInfo);
}
