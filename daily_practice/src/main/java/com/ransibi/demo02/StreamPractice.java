package com.ransibi.demo02;


import java.io.*;

public class StreamPractice {
    public static void main(String[] args) {
        getFileInfo();
        outFileInfo();
    }


    /**
     * FileInputStream应用实例
     */
    private static void getFileInfo() {
        //请使用FileInputStream读取hello.txt文件，并将文件内容显示到控制台
        //单个字节的读取
        String filePath = "D:\\gitee\\io_learn\\daily_practice\\read_path\\hello.txt";
        String readDate = null;//读取到的内容
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //解决读取文件中的中文乱码的问题，使用InputStreamReader将FileInputStream转换为FileReader并指定编码格式
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            //如果返回-1，表示读取完毕
            while ((readDate = br.readLine()) != null) {
                System.out.print(readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件，释放资源
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * FileOutputStream应用实例
     */
    private static void outFileInfo() {
        //使用FileOutputStream在a.txt文件中写入"hello world!"
        //如果文件不存在，会自动创建文件(注意: 前提是目录已经存在)
        String filePath = "D:\\gitee\\io_learn\\daily_practice\\read_path\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //1.new FileOutputStream(filePath)创建，每次执行代码后打开文件会覆盖上一次写的内容
            //2.new FileOutputStream(filePath, true)创建，每次执行代码后打开文件会在上一次的基础上追加新的内容
            fileOutputStream = new FileOutputStream(filePath, true);
            //写入一个字节
            fileOutputStream.write('h');
            //写入字符串
            String str = "hello world!";
            //str.getBytes() 字符串->字符数组
            fileOutputStream.write(str.getBytes());
            //write(byte b[], int off, int len) 从off开始写入b数组的len个字节
            fileOutputStream.write(str.getBytes(), 0, 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
