package project;

import java.io.*;

/*
拷贝一张图片
 */
public class project5 {
    //
    public static void Copy()throws IOException{
        File file = new File("D:\\女孩.jpg");
        File file1 = new File("F:\\小女孩.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        //可以不加true；
        FileOutputStream fileOutputStream = new FileOutputStream(file1,true);
        byte[] buf = new byte[1024];
        int length = 0;
        while((length = fileInputStream.read(buf))!=-1){
            fileOutputStream.write(buf,0,length);
        }
        //先开后关
        fileOutputStream.close();
        fileInputStream.close();

    }
    //使用缓冲输入输出字节来拷贝一张图片
    private static void Copy1() throws  IOException{
        File file = new File("D:\\女孩.jpg");
        File file1 = new File("F:\\小小女孩.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        //可以不加true；
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        //边读边写
        int count = 0;
        while((count = bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(count);
            //bufferedOutputStream.flush();不用此语句，等满了送过去，效率会更高。
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
    //使用缓冲输入输出字符流拷贝一张图片
    public static void Copy2()throws IOException{
        File file = new File("D:\\女孩.jpg");
        File file1 = new File("F:\\小小小女孩.jpg");
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file1);
        //char[] buf = new char[1024];
        int length = 0;
        while((length = fileReader.read())!=-1){
            fileWriter.write(length);
        }
        fileWriter.close();
        fileReader.close();

    }
    //使用缓冲输入输出字符流拷贝文本
    public static void Copy3()throws IOException{
        File file = new File("F:\\a.txt");
        File file1 = new File("D:\\a.txt");
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file1);
        char[] buf = new char[1024];
        int length = 0;
        while((length = fileReader.read(buf))!=-1){
            fileWriter.write(buf,0,length);
        }
        fileWriter.close();
        fileReader.close();
    }
    public static void main(String[] args) throws IOException {
        //Copy();
        //Copy1();
        //Copy2();
        Copy3();
    }


}
