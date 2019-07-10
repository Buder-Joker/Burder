package project;

import java.io.*;
//需求：编写一个类BufferReadlinenum 扩展BufferedReader的read方法，加上行号。
class BufferReadlinenum extends BufferedReader{
    int count = 1;
    public BufferReadlinenum(Reader in) {
        super(in);
    }
    public String readLine() throws IOException {
        String line = super.readLine();
        if(super.readLine()==null){
            return null;
        }
        line = count + " "+ line;
        count++;
        return line;
    }
}
public class project7 {
    public static void main (String[] args) throws IOException {
        read3();
        //read1();
        //read();
    }
    //缓冲字符流输入
    private static void read() throws IOException {
        File file = new File("F:\\a.txt");
        FileReader fileReader = new FileReader(file);
        int length = 0;
        char[] buf = new char[1024];
        while((length = fileReader.read(buf))!=-1){
            System.out.print(new String(buf,0,length));
        }
        fileReader.close();
    }
    private static void read1() throws IOException {
        File file = new File("F:\\b.txt");
        FileReader fileReader = new FileReader(file);
        int count = 0;
        while((count = fileReader.read())!=-1){
            System.out.print((char)count);
        }
        fileReader.close();
    }
    private static void read3() throws IOException {
        File file = new File("F:\\b.txt");
        FileReader fileReader = new FileReader(file);
        //BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferReadlinenum bufferReadlinenum = new BufferReadlinenum(fileReader);
        String count = null;
        while((count = bufferReadlinenum.readLine())!=null){
            System.out.println(count);
        }
        bufferReadlinenum.close();
    }
}
