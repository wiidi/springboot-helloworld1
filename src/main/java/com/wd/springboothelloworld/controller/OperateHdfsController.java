package com.wd.springboothelloworld.controller;


import com.wd.springboothelloworld.service.OperateHdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/15 15:47
 * @UpdateUser:
 * @UpdateDate: 2018/11/15 15:47
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
@RequestMapping("/HDFS")
public class OperateHdfsController {

    @Autowired
    OperateHdfsService operateHdfsService;

    /**
     * 查看目录及文件
     * hdfs dfs -ls /user/wudi
     * @param folder
     * @return
     */
    @RequestMapping("/list")

    public String list(String folder){
        return operateHdfsService.list(folder);
    }

    /**
     * 新建文件夹
     * hdfs dfs -mkdir /user/wudi
     * @param folder
     * @return
     */
    @RequestMapping("mkDir")
    public String mkDir(String folder){
        return operateHdfsService.mkDir(folder);
    }

    /**
     * 删除文件夹
     * hadoop fs -rm -r /user/wudi/test
     * @param floder
     * @return
     */
    @RequestMapping("delDir")
    public String delDir(String floder){
        return operateHdfsService.delDir(floder);
    }

    /**
     * 获取文件系统中文件元数据信息
     *
     * @param floderName
     * @return
     */
    @RequestMapping("getStatus")
    public Object getStatus(String floderName){
        return operateHdfsService.getStatus(floderName);
    }

    /**
     * 上传文件
     * @param localPath
     * @param remote
     * @return
     */
    @RequestMapping("uploadFile")
    public String uploadFile(String localPath, String remote){
        return operateHdfsService.uploadFile(localPath, remote);
    }

    /**
     * 下载文件
     * @param remote
     * @param local
     * @return
     */
    @RequestMapping("downloadFile")
    public String downloadFile(String remote, String local){
        return operateHdfsService.downloadFile(remote, local);
    }

    /**
     * 重命名
     * @param old_name
     * @param new_name
     */
    @RequestMapping("rename")
    public void rename(String old_name, String new_name){
        operateHdfsService.rename(old_name,new_name);
    }

    /**
     * 查看文件
     * @param remoteFile
     * @return
     */
    @RequestMapping("catFile")
    public String catFile(String remoteFile){
        return operateHdfsService.catFile(remoteFile);
    }

    /**
     * 压缩所有文件
     * @param inputName
     * @param outputName
     */
    @RequestMapping("decompression")
    public void decompression(String inputName, String outputName){
        operateHdfsService.decompression(inputName,outputName);
    }


}
