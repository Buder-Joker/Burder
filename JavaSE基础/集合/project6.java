package project;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class project6 {
    public static void main(String[] args) throws IOException{
        read1();
    }

    private static void read() throws IOException {
        //找到目标文件
        File file = new File("F:\\a.txt");
        //建立数据的输入通道
        FileInputStream fileInputStream = new FileInputStream(file);
        /*
        疑问一：为什么创建BufferedInputStream的时候需要传入FileInputStream？
           因为BufferedInputStream本身不具备读文件能力，所以需要借助FileInputStream来读文件
         */
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //读取文件数据
        int count = 0;
        while((count = bufferedInputStream.read())!=-1){
            System.out.print((char)count);
        }
        //调用bufferedInputStream的close方法实际是调用FileInputStream的close的方法。
        bufferedInputStream.close();
    }
    private static void read1() throws IOException {
        File file = new File("F:\\b.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader =new BufferedReader(fileReader);
        String line = null;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
        fileReader.close();
   }
}
