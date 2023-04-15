package com.classloader.demo;

import java.io.*;

/**
 * @author 吴凯斌
 * 创建时间 2023/1/28 16:48
 */
public class MyClassLoader extends ClassLoader {

    private String root;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }

        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar + className + ".class";

        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bufferSize = 1024;

            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = inputStream.read()) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("/Users/michael/IdeaProjects/javaDemo");

        Class<?> testClass = null;
        try {
            // class文件为移动到桌面的Test.class文件
            testClass = classLoader.loadClass("com.classloader.demo.Test");
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
