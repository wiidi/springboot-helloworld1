package com.wd.springboothelloworld.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


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
@Service
public class OperateHdfsService {
//
//    @Value("${hdfs.hdfs-url}")
    public String HDFS_url = "hdfs://10.96.14.58:8020";
//    private String HDFS_url ;
//
//    @Value("${hdfs.hdfs_separator}")
//    private String HDFS_separator;
    public String HDFS_separator = "/";
//
//    @Value("${hdfs.hadoop-home-Dir}")
//    private String hadoopHomeDir;
    public String hadoopHomeDir = "D:\\hadoop-2.7.3";

//    @Value("${hdfs.default-fs}")
//    private String defaultFS;
    public String defaultFS = "hdfs://10.96.14.58:8020";

    public String getHDFS_url() {
        return HDFS_url;
    }

    public OperateHdfsService() {

        //需要在windows上安装hadoop-2.7.3
        System.setProperty("hadoop.home.dir", hadoopHomeDir);
    }

    public Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", defaultFS);
        return configuration;
    }

    public FileSystem getFileSystem() {
        FileSystem fs = null;
        try {
            fs = FileSystem.get(URI.create(HDFS_url), getConfiguration());
            if (fs == null) {
                System.out.println("fs is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fs;
    }

    /**
     * 查看目录及文件
     * hdfs dfs -ls /user/wudi
     *
     * @param folder
     * @return
     */
    public String list(String folder) {
        FileSystem fs = null;
        StringBuffer sb = new StringBuffer();
        try {
            Path path = new Path(folder);
            fs = getFileSystem();

            FileStatus[] list = fs.listStatus(new Path(folder));
            System.err.println("查看文件及目录结果.....size :" + list == null ? null : list.length);
            for (FileStatus f : list) {
                System.err.printf("name: %s, folder: %s, size: %d\n", f.getPath(),
                        f.isDir(), f.getLen());
                sb.append("name:").append(f.getPath()).append(",folder:").append(f.isDir()).append(",size:" + f.getLen()).append("\r\n");
            }
            fs.close();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 新建文件夹
     * hdfs dfs -mkdir /user/wudi
     *
     * @param folder
     * @return
     */
    public String mkDir(String folder) {
        Path path = new Path(folder);
        FileSystem fs = getFileSystem();
        try {
            if (!fs.exists(path)) {
                fs.mkdirs(path);
            } else {
                //            throw new Exception("path exists!");
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 删除文件夹
     * hadoop fs -rm -r /user/wudi/test
     *
     * @param floder
     * @return
     */
    public String delDir(String floder) {
        Path path = new Path(floder);
        try {
            FileSystem fs = getFileSystem();
            if (fs.exists(path)) {
                fs.deleteOnExit(path);
            } else {
                throw new Exception("path not exists!");
            }
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取文件系统中文件元数据信息
     *
     * @param floderName
     * @return
     */
    public Object getStatus(String floderName) {
        FileSystem fs = getFileSystem();
        Path path = new Path(floderName);

        FileStatus status = null;
        try {
            status = fs.getFileStatus(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
        System.out.println(status.getAccessTime() + " " +
                status.getBlockSize() + " " +
                status.getPath() + " " +
                status.getOwner());
        System.out.println("-----------------------------");
        return null;
    }

    /**
     * 上传文件
     *
     * @param localPath
     * @param remote
     * @return
     */
    public String uploadFile(String localPath, String remote) {
        FileSystem fs = null;
        try {
            fs = getFileSystem();
            fs.copyFromLocalFile(new Path(localPath), new Path(remote));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载文件
     *
     * @param remote
     * @param local
     * @return
     */
    public String downloadFile(String remote, String local) {
        FileSystem fs = getFileSystem();
        fs.setVerifyChecksum(false);

//        Configuration configuration = new Configuration();
//
//        FileSystem fs = new RawLocalFileSystem();
//        fs.initialize(new URI(HDFS_url),configuration);
        try {
            fs.copyToLocalFile(new Path(remote), new Path(local));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 重命名
     *
     * @param old_name
     * @param new_name
     */
    public void rename(String old_name, String new_name) {
        FileSystem fs = getFileSystem();
        try {
            fs.rename(new Path(old_name), new Path(new_name));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查看文件
     *
     * @param remoteFile
     * @return
     */
    public String catFile(String remoteFile) {
        OutputStream out = new ByteArrayOutputStream();
        InputStream in = null;
        String str = null;
        FileSystem fs = null;
        try {
            fs = getFileSystem();
            in = fs.open(new Path(remoteFile));
            IOUtils.copyBytes(in, out, 4096, false);
            str = out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                IOUtils.closeStream(in);
            if (fs != null)
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return str;
    }

    private byte[] InputStream2ByteArray(String filePath) throws Exception {
        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        in.close();
        return data;
    }

    private byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

    public void continueUpload(String local, String remote) {
        FileSystem fs = null;
        try {
            fs = getFileSystem();
            Path localPath = new Path(local);
            Path remotePath = new Path(remote);

            if (!fs.exists(remotePath)) {
                uploadFile(local, remote);
            } else {
                FSDataOutputStream write = fs.append(localPath);
                write.write(InputStream2ByteArray(local));
                write.flush();
                write.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 压缩所有文件
     *
     * @param inputName
     * @param outputName
     */
    public void decompression(String inputName, String outputName) {
        Path inputPath = new Path(inputName);
        Path outputPath = new Path(outputName);
        System.out.println(inputPath.getName());
        Configuration configuration = getConfiguration();
        //不加会报错
        configuration.setBoolean("fs.hdfs.impl.disable.cache", true);
        FileSystem hdfs = null;

        FSDataInputStream in = null;
        ZipInputStream zipInputStream = null;
        try {
            hdfs = FileSystem.get(configuration);
            in = hdfs.open(inputPath);
            zipInputStream = new ZipInputStream(in);
            ZipEntry entry;

            mkDir(outputName);
            while ((entry = zipInputStream.getNextEntry()) != null) {
                FSDataOutputStream mergerout = hdfs.create(new Path(outputPath + HDFS_separator + entry.getName()));
                System.out.println(outputPath + entry.getName());
                int bygeSize = 1024 * 2 * 1024;
                byte[] buffer = new byte[bygeSize];
                int nNumber;
                while ((nNumber = zipInputStream.read(buffer, 0, bygeSize)) != -1) {
                    mergerout.write(buffer, 0, nNumber);
                }
                mergerout.flush();
                mergerout.close();
            }

            zipInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
