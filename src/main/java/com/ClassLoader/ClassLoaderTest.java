package com.ClassLoader;

/**
 * @author guanzhiding
 * @date 2021/2/25 14:31
 */
public class ClassLoaderTest {
    static {
        System.out.println("静态初始化块执行了！");
    }
    public static void main(String[] args) {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
