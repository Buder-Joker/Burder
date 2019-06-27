package project;
/*
装饰者设计模式：增强一个类的功能，而且还可以让这些装饰类互相装饰


装饰者设计模式的步骤：
-------1.在装饰类内部维护了一个被装饰类的引用
-------2.让装饰类有一个共同的父类或父接口

继承实现的增强类和修饰模式实现的增强类有何区别？
	继承实现的增强类：
		优点：代码结构清晰，而且实现简单.
		缺点：对于每一个的需要增强的类都要创建具体的子类来帮助其增强，这样会导致继承体系过于庞大。

修饰模式实现的增强类：
		优点：内部可以通过多态技术对多个需要增强的类进行增强， 可以是这些装饰类达到互相装饰的效果。使用比较灵活。

		缺点：需要内部通过多态技术维护需要被增强的类的实例。进而使得代码稍微复杂。
 */
import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
//带行号缓冲的输入字符流
class BufferReaderNum extends BufferedReader{//为什么要继承？是为了让这些装饰类的对象可以作为参数进行传递，达到互相装饰的效果
    //在内部维护一个被装饰类的引用
    BufferedReader bufferedReader;
    int count = 1;
    public BufferReaderNum(BufferedReader bufferedReader){
        super(bufferedReader);//这句话没有任何作用，只是为了不报错
        this.bufferedReader = bufferedReader;
    }
    public String readLine() throws IOException {
        String line = bufferedReader.readLine();
        if(line==null){
            return null;
        }
        line = count+" "+ line;
        count++;
        return line;
    }
}
//带分号缓冲输入字符流
class BufferReaderfenhao extends BufferedReader{
    //在内部维护一个被装饰类的引用
    BufferedReader bufferedReader;
    public BufferReaderfenhao(BufferedReader bufferedReader){
        super(bufferedReader);//这句话没有任何作用，只是为了不报错
        this.bufferedReader = bufferedReader;
    }
    public String readLine() throws IOException {
        String line = bufferedReader.readLine();
        if(line==null){
            return null;
        }
        line = line + ";";
        return line;
    }
}
//带双引号的缓冲输入字符流
class BufferReaderyinhao extends BufferedReader{
    BufferedReader bufferedReader;
    public BufferReaderyinhao(BufferedReader bufferedReader){
        super(bufferedReader);
        this.bufferedReader = bufferedReader;
    }

    public String readLine() throws IOException {
        String line = bufferedReader.readLine();
        if(line==null){
            return null;
        }
        line = "\""+line+"\"";
        return line;
    }
}
public class project8 {
    public static void main(String[] args) throws IOException{
        File file = new File("F:\\b.txt");
        FileReader fileReader = new FileReader(file);
        //建立缓冲输入字符流
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //建立带引号缓冲输入字符流
        BufferReaderyinhao bufferReaderyinhao = new BufferReaderyinhao(bufferedReader);
        //建立带行号的缓冲输入字符流
        BufferReaderNum bufferReaderNum = new BufferReaderNum(bufferReaderyinhao);
        //建立带分号缓冲输入字符流
        BufferReaderfenhao bufferReaderfenhao = new BufferReaderfenhao(bufferReaderNum);

        String line = null;
        while((line = bufferReaderfenhao.readLine())!=null){
            System.out.println(line);
        }
    }
}
