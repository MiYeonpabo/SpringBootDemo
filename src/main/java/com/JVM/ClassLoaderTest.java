package com.JVM;

/**
 * @author guanzhiding
 * @date 2021/2/2 15:25
 */
public class ClassLoaderTest {


//    public static void main(String[] args) {
//        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
//        System.out.println(classLoader);
//        System.out.println(classLoader.getParent());
//        System.out.println(classLoader.getParent().getParent());
//    }

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Test2.class.getClassLoader();
        System.out.println(classLoader);
        classLoader.loadClass("Test2");
//        Class.forName("Test2");
    }
}
