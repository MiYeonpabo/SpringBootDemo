package com.ClassLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guanzhiding
 * @date 2021/2/25 14:40
 */
public class loaderTest {
    //    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        System.out.println(classLoader);
////        classLoader.loadClass("com.ClassLoader.ClassLoaderTest");
////        Class.forName("com.ClassLoader.ClassLoaderTest");
//        Class.forName("com.ClassLoader.ClassLoaderTest", false, classLoader);
//    }
    public static void main(String[] args) {
        System.out.println('b'-'a');
//        System.out.println('a' ^ 0);
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[puzzles.length];
        for (int i = 0; i < puzzles.length; i++) {
            int puzzlesLen=puzzles[i].length();
            for (int j = 0; j < words.length; j++) {
                int wordsLen=words[j].length();
                if (words[j].indexOf(puzzles[i].charAt(0)) != -1) {
                    int len = 0;
                    for (int k = 0; k < words[j].length(); k++) {
                        if (puzzles[i].indexOf(words[j].charAt(k)) != -1) {
                            len++;
                        }
                    }
                    if (len == words[j].length()) {
                        arr[i] = arr[i] + 1;
                    }
                }
            }
            list.add(arr[i]);
        }
        return list;
    }
}
