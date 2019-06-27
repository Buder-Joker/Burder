package project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class project4 {
    public static void main(String[] args) throws IOException {
        //write();
        write1();
    }
    //使用输出缓冲字节流
    public static void write() throws IOException{
        //找到数据文件
        File file  = new File("F:\\c.txt");
        //建立数据输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        //把数据写出
        String data = "今天天气不错！";
        fileOutputStream.write(data.getBytes());
        //关闭资源
        fileOutputStream.close();
    }
    //使用输出缓冲字符流
    public static void write1() throws IOException{
        //找到数据文件
        File file  = new File("F:\\c.txt");
        //建立数据输出通道
        FileWriter fileWriter= new FileWriter(file,true);
        //把数据写出
        String data = "今天天气不错！";
        fileWriter.write(data);
        //关闭资源**必须关闭才能输出因为FileWriter他爷Writer内部维护了一个1024大小的数组。
        fileWriter.close();
    }
}
