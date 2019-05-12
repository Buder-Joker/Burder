package projectNet;
/*
tcp的服务端
/*
	java.net.BindException:   端口被占用。
ServerSocket的使用 步骤
	1. 建立tcp服务端 的服务。
	2. 接受客户端的连接产生一个Socket.
	3. 获取对应的流对象读取或者写出数据。
	4. 关闭资源。
为什么ServerSocket不设计一个getInputStream与getOutputStream 呢？
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class projectNetS2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int length = 0;
        length = inputStream.read(buf);
        System.out.println("服务器接收："+new String(buf,0,length));
        serverSocket.close();
    }
}
