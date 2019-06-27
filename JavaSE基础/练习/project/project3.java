package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class project3 {
    public static void main(String[] args) throws IOException {
        read2();
    }

    //使用缓冲数组读取配合循环读取
    public static void read2() throws IOException{
        File file = new File("F:\\b.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buf = new byte[1024];//相当于超市里边的购物车
        int length = 0;
        while((length = fileInputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,length));
        }
        fileInputStream.close();
    }


    //使用缓冲数组读取   缺点：无法安全读取文件的数据
    public static void read1() throws IOException{
        //找到目标文件
        File file = new File("F:\\a.txt");
        //建立数据的输入管道
        FileInputStream fileInputStream = new FileInputStream(file);
        //建立缓冲字节数组，读取文件数据
        byte[] buf = new byte[4];//相当于超市里边的购物车
        //如果使用read读取数据传入字节数组中，那么数组是存储到字节数组的，read方法返回的是表示本次读取了几个
        //字节到字节数组中
        int length = fileInputStream.read(buf);
        System.out.println(length);
        //使用字节数组建立字符串
        String s = new String(buf,0,length);
        System.out.println(s);
        //关闭资源
        fileInputStream.close();
    }


    //使用循环读取文件的数据
    public  static void read() throws IOException {
        File file = new File("F:\\a.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        int count = 0;
        while((count = fileInputStream.read())!=-1){
            System.out.print((char)count);
        }
        fileInputStream.close();
    }
}
