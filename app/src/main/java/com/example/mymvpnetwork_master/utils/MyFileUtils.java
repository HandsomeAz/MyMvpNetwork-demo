package com.example.mymvpnetwork_master.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author : zlj
 * date : 2021/8/23 2:05 PM
 * description :文件工具类
 */
public class MyFileUtils {

    private static final String TAG = "FileUtils";
    public static final int FLAG_SUCCESS = 1;//创建成功
    public static final int FLAG_EXISTS = 2;//已存在
    public static final int FLAG_FAILED = 3;//创建失败

    public static File getNewVersionDirectory() {
        // 获取根目录
        File sdRootFile = getSDRootFile();
        File file = null;
        if (sdRootFile != null && sdRootFile.exists()) {
            file = new File(sdRootFile, "downloads");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }
    /**
     * 写入TXT文件
     */
    public static boolean writeTxtFile(String content, String filePath) {
        if (content.isEmpty()||filePath.isEmpty())
            return false;
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }

        RandomAccessFile mm = null;
        boolean flag = false;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes("utf-8"));
            fileOutputStream.close();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * Checks if is sd card available.检查SD卡是否可用
     */
    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * Gets the SD root file.获取SD卡根目录
     */
    public static File getSDRootFile() {
        if (isSdCardAvailable()) {
            return Environment.getExternalStorageDirectory();
        } else {
            return null;
        }
    }


    public static File getVideoDirectory() {
        // 获取根目录
        File sdRootFile = getSDRootFile();
        File file = null;
        if (sdRootFile != null && sdRootFile.exists()) {
            file = new File(sdRootFile, "AliPlayerApp/VideoManage");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    public static File getDownloadDirectory() {
        // 获取根目录
        File sdRootFile = getSDRootFile();
        File file = null;
        if (sdRootFile != null && sdRootFile.exists()) {
            file = new File(sdRootFile, "AliPlayerApp/DownloadManage");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    public static File getCopeVideoDirectory() {
        // 获取根目录
        File sdRootFile = getSDRootFile();
        File file = null;
        if (sdRootFile != null && sdRootFile.exists()) {
            file = new File(sdRootFile, "AliPlayerApp/CopeVideoManage");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    public static File getAdVideoDirectory() {
        // 获取根目录
        File sdRootFile = getSDRootFile();
        File file = null;
        if (sdRootFile != null && sdRootFile.exists()) {
            file = new File(sdRootFile, "AliPlayerApp/AdVideoManage");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    public static File getDownloadVideoDirectory() {
        // 获取根目录
        File sdRootFile = getSDRootFile();
        File file = null;
        if (sdRootFile != null && sdRootFile.exists()) {
            file = new File(sdRootFile, "AliPlayerApp/downloadManage");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    public static File getNewErrLogDirectory() {
        // 获取根目录
        File sdRootFile = getSDRootFile();
        File file = null;
        if (sdRootFile != null && sdRootFile.exists()) {
            file = new File(sdRootFile, "AliPlayerApp/ErrorLog");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }



    /**
     * 判断文件是否存在
     */
    public static File isFileExist(String fileDirectory, String fileName) {
        File file = new File(fileDirectory + "/" + fileName);
        try {
            if (!file.exists()) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return file;
    }

    /**
     * 删除文件
     */
    public static void deleteFile(String filePath) {
        try {
            // 找到文件所在的路径并删除该文件
            File file = new File(filePath);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取不带扩展名的文件名
     * */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }



    public static void copyFile(String oldPath, String newPath) {

        if (oldPath.isEmpty()||newPath.isEmpty())
            return;
        InputStream inStream = null;
        FileOutputStream fs = null;
        boolean result = false;
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            // 判断目录是否存在
            File newfile = new File(newPath);
            File newFileDir = new File(newfile.getPath().replace(newfile.getName(), ""));
            if (!newFileDir.exists()) {
                newFileDir.mkdirs();
            }
            if (oldfile.exists()) { // 文件存在时
                inStream = new FileInputStream(oldPath); // 读入原文件
                fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 创建 单个 文件
     * @param filePath 待创建的文件路径
     * @return 结果码
     */
    public static int CreateFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return FLAG_EXISTS;
        }
        if (filePath.endsWith(File.separator)) {// 以 路径分隔符 结束，说明是文件夹
            return FLAG_FAILED;
        }

        //判断父目录是否存在
        if (!file.getParentFile().exists()) {
            //父目录不存在 创建父目录
            if (!file.getParentFile().mkdirs()) {
                return FLAG_FAILED;
            }
        }

        //创建目标文件
        try {
            if (file.createNewFile()) {//创建文件成功
                return FLAG_SUCCESS;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return FLAG_FAILED;
        }

        return FLAG_FAILED;
    }
    /**
     *删除本地文件
     */
    public static void deleteLocal(File file){
        if (file==null)
            return;
        if(file.exists()){
            if(file.isFile()){
                file.delete();//如果为文件，直接删除
            }else if(file.isDirectory()){
                File[]files=file.listFiles();
                for(File file1:files){
                    deleteLocal(file1);//如果为文件夹，递归调用
                }
            }
            // file.delete();
        }
    }

    public static void copy(String path) {
        String name ="拷贝的图片";
        String[] s = path.split("/");
        name = s[s.length-1];
        try {
            int len = 0;
            InputStream is = new FileInputStream(path);
            File faceDir = MyFileUtils.getCopeVideoDirectory();
            File file = new File(faceDir, name);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buf = new byte[2048];
            while((len = is.read(buf))!= -1){
                fos.write(buf,0,len);
            }
            fos.flush();
            fos.close();
            is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyVideo(String path) {
        final File downloadVideoDirectory = MyFileUtils.getDownloadVideoDirectory();
        String newPath = downloadVideoDirectory.getPath()+"/"+path;
        String name ="";
        String[] s = newPath.split("/");
        name = s[s.length-1];
        try {
            int len = 0;
            InputStream is = new FileInputStream(newPath);
            File faceDir = MyFileUtils.getVideoDirectory();
            File file = new File(faceDir, name);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buf = new byte[2048];
            while((len = is.read(buf))!= -1){
                fos.write(buf,0,len);
            }
            fos.flush();
            fos.close();
            is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //文件拷贝
    //要复制的目录下的所有非子目录(文件夹)文件拷贝
    public static void CopySdcardFile(String fromFile, String toFile)
    {

        try
        {
            InputStream fosfrom = new FileInputStream(fromFile);
            OutputStream fosto = new FileOutputStream(toFile);
            byte bt[] = new byte[1024];
            int c;
            while ((c = fosfrom.read(bt)) > 0)
            {
                fosto.write(bt, 0, c);
            }
            fosfrom.close();
            fosto.close();

        } catch (Exception ex)
        {
        }
    }

    public static List<String> getVideoPaths(int type) {
        File importDir = null;
        List<String> list = new ArrayList<>();
        File[] picFiles;
        // 1、获取导入目录 /sdcard/Face-Import
        if (type==0){
            importDir = MyFileUtils.getVideoDirectory();
        }else if (type ==1){
            importDir = MyFileUtils.getCopeVideoDirectory();
        }else {
            importDir = MyFileUtils.getAdVideoDirectory();
        }
        // 2、遍历该目录下的所有文件
        picFiles = importDir.listFiles();
        if (picFiles!=null){
            if (picFiles.length>0){
                for (File file:picFiles){
                    if (checkIsImageFile(file.getPath())){
                        list.add(file.getPath());
                    }
                }
            }
        }
        return list;
    }
    /**
     * 检查扩展名，得到图片格式的文件
     * @param fName  文件名
     * @return
     */
    @SuppressLint("DefaultLocale")
    private static boolean checkIsImageFile(String fName) {
        boolean isImageFile = false;
        // 获取扩展名
        String FileEnd = fName.substring(fName.lastIndexOf(".") + 1,
                fName.length()).toLowerCase();
        if (FileEnd.equals("mp4") || FileEnd.equalsIgnoreCase("m4v")
                || FileEnd.equalsIgnoreCase("avi")
                || FileEnd.equalsIgnoreCase("qt")
                || FileEnd.equalsIgnoreCase("wmv")
                || FileEnd.equalsIgnoreCase("rm")
                || FileEnd.equalsIgnoreCase("mov")
                || FileEnd.equalsIgnoreCase("mpe")) {

            isImageFile = true;
        } else {
            isImageFile = false;
        }
        return isImageFile;
    }

    public static List<String> getFilesAllName() {
        File file=getVideoDirectory();
        File[] files=file.listFiles();
        Log.e("file","空目录"+file+">>>>>>>>>"+files);
        if (files == null){
            Log.e("error","空目录");return null;}
        List<String> s = new ArrayList<>();
        List<String> filesAllName = new ArrayList<>();
        for (File value : files) {
            s.add(value.getName());
        }
        if (s.size()>0){
            for (String fileName : s) {

                if (fileName.contains("_")){
                    String[] data = fileName.split("_");
                    String name = data[0];
                    filesAllName.add(name);
                }
            }
        }
        return filesAllName;
    }

}
