package com.ransibi.demo01;

import java.io.File;
import java.io.IOException;

/**
 * 常用的文件操作
 */
public class CommonOperation {
    /**
     * 创建文件
     */
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName() + "开始创建");
//        createFileByPath();
//        create02();
//        create03();
//        System.out.println(Thread.currentThread().getName() + "结束创建");
//        getFileInfo();
//        dirOperation();
//        dirOperation01();
        createSigDir();
//        createMutiDir();
    }

    /**
     * 根据路径创建
     */
    public static void createFileByPath() {
        String filePath = "D:\\gitee\\io_learn\\daily_practice\\out_path\\test01.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件test01.txt创建成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据父目录（File类型）+子路径创建
     */
    public static void create02() {
        File parentFile = new File("D:\\gitee\\io_learn\\daily_practice\\out_path\\");
        String fileName = "test02.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件test02.txt创建成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据父目录(String类型)+子路径创建
     */
    public static void create03() {
        String parentPath = "D:\\gitee\\io_learn\\daily_practice\\out_path\\";
        String fileName = "test03.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件test03.txt创建成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文件相关信息
     */
    public static void getFileInfo() {
        File file = new File("D:\\gitee\\io_learn\\daily_practice\\out_path\\test01.txt");
        System.out.println("文件名字:" + file.getName());
        System.out.println("文件绝对路径:" + file.getAbsolutePath());
        System.out.println("文件父级目录:" + file.getParent());
        System.out.println("文件大小(byte):" + file.length());
        System.out.println("文件是否存在:" + file.exists());
        System.out.println("是否是一个文件:" + file.isFile());
        System.out.println("是否是一个目录:" + file.isDirectory());
    }

    /**
     * 目录的操作和删除
     */
    public static void dirOperation() {
        File file = new File("D:\\gitee\\io_learn\\daily_practice\\out_path\\test01.txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("test01.txt删除成功!");
            }
        } else {
            System.out.println("文件test01.txt不存在!");
        }
    }

    /**
     * 在java中，目录也当成文件来处理
     */
    public static void dirOperation01() {
        File file = new File("D:\\gitee\\io_learn\\daily_practice\\demo");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("demo删除成功!");
            } else {
                System.out.println("demo删除失败!");
            }
        } else {
            System.out.println("目录demo不存在!");
        }
    }

    /**
     * 创建一级目录
     */
    public static void createSigDir(){
        String directoryPath = "D:\\gitee\\io_learn\\daily_practice\\out_path\\a";
        File file = new File(directoryPath);
        if(file.exists()) {
            System.out.println(directoryPath + "目录存在!");
        } else {
            if(file.mkdir()) {
                System.out.println(directoryPath + "目录创建成功!");
            } else {
                System.out.println(directoryPath + "目录创建失败!");
            }
        }
    }


    /**
     * 创建多级目录
     */
    public static void createMutiDir(){
        String directoryPath = "D:\\gitee\\io_learn\\daily_practice\\out_path\\a\\b\\c";
        File file = new File(directoryPath);
        if(file.exists()) {
            System.out.println(directoryPath + "目录存在!");
        } else {
            if(file.mkdirs()) {
                System.out.println(directoryPath + "目录创建成功!");
            } else {
                System.out.println(directoryPath + "目录创建失败!");
            }
        }
    }
}
