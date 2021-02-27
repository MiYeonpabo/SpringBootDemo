package com.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author guanzhiding
 * @date 2021/2/25 15:06
 */
public class MyClassLoader extends ClassLoader {

    private String root;

    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] classData = loadClassData(className);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(className, classData, 0, classData.length);
        }
    }


    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream inputStream = new FileInputStream(fileName);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bufferSize = 1024;
            int length = 0;
            byte[] buffer = new byte[bufferSize];
            while ((length = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            byteArrayOutputStream.close();
            inputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
        }
        return null;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getRoot() {
        return root;
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
//        myClassLoader.setRoot("");
        Class<?> testClass = null;
        try {
            testClass = myClassLoader.findClass("D:\\CODE_NEW\\analyzer\\emdata_analyzer\\emdata-spider\\emdata-spider-analyzer\\emdata-spider-analyzer-business\\src\\main\\java\\com\\emdata\\spider\\emr\\maidisidun\\xincaigeshi\\Hospital982EmrServiceImpl");
            Object object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
