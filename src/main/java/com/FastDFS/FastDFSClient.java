package com.FastDFS;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.ServerInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author guanzhiding
 * @date 2021/1/20 11:18
 */
public class FastDFSClient {

    private static Logger logger = LoggerFactory.getLogger(FastDFSClient.class);

    //初始化
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (IOException e) {
            logger.error("FastDFS Client Init Fail!", e);
        } catch (Exception e) {
            logger.error("FastDFS Client Init Fail!", e);
        }
    }

    //上传
    public static String[] uploadFile(FastDFSFile file) {
        logger.info("File Name" + file.getName() + ";" + "File Length" + file.getContent().length);
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());
        long startTime = System.currentTimeMillis();
        String[] uploadResults = null;
        StorageClient storageClient = null;
        try {
            storageClient = getTrackerClient();
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (Exception e) {
            logger.error("IO Exception when uploadind the file:" + file.getName(), e);
        }
        logger.info("upload_file time used:" + (System.currentTimeMillis() - startTime) + " ms");
        if (uploadResults == null && storageClient != null) {
            logger.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];
        logger.info("upload file successfully!!!" + "group_name:" + groupName + ", remoteFileName:" + " " + remoteFileName);
        return uploadResults;
    }

    //获取文件信息
    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            StorageClient client = getTrackerClient();
            return client.get_file_info(groupName, remoteFileName);
        } catch (IOException e) {
            logger.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            logger.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    //下载
    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            StorageClient client = getTrackerClient();
            byte[] fileBytes = client.download_file(groupName, remoteFileName);
            InputStream inputStream = new ByteArrayInputStream(fileBytes);
            return inputStream;
        } catch (IOException e) {
            logger.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            logger.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    //删除
    public static void deleteFile(String groupName, String remoteFileName) throws Exception {
        StorageClient client = getTrackerClient();
        int count = client.delete_file(groupName, remoteFileName);
        logger.info("delete file successfully!!!" + count);
    }

    public static StorageServer[] getStorageServer(String groupName) throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        return trackerClient.getStoreStorages(trackerServer, groupName);
    }

    public static ServerInfo[] getFetchStorages(String groupName, String remoteFileName) throws Exception {
        TrackerClient client = new TrackerClient();
        TrackerServer trackerServer = client.getTrackerServer();
        return client.getFetchStorages(trackerServer, groupName, remoteFileName);
    }

    public static String getTrackerUrl() throws Exception {
        return "http://" + getTrackerServer().getInetSocketAddress().getHostString() + ":" + ClientGlobal.getG_tracker_http_port() + "/";
    }

    private static StorageClient getTrackerClient() throws Exception {
        TrackerServer trackerServer = getTrackerServer();
        return new StorageClient(trackerServer, null);
    }

    private static TrackerServer getTrackerServer() throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        return trackerServer;
    }
}
