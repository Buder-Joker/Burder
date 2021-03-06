package projectNet;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
UDP通讯协议的特点：
	1. 将数据极封装为数据包，面向无连接。
	2. 每个数据包大小限制在64K中
	3.因为无连接，所以不可靠
	4. 因为不需要建立连接，所以速度快
	5.udp 通讯是不分服务端与客户端的，只分发送端与接收端。

TCP通讯协议特点：
	1. tcp是基于IO流进行数据 的传输 的，面向连接。
 	2. tcp进行数据传输的时候是没有大小限制的。
 	3. tcp是面向连接，通过三次握手的机制保证数据的完整性。 可靠协议。
 	4. tcp是面向连接的，所以速度慢。
 	5. tcp是区分客户端与服务端 的。

 	比如： 打电话、 QQ\feiQ的文件传输、 迅雷下载....

tcp协议下的Socket：
	Socket(客户端) , tcp的客户端一旦启动马上要与服务端进行连接。
	ServerSocket(服务端类)

tcp的客户端使用步骤：
	1. 建立tcp的客户端服务。
	2. 获取到对应的流对象。
	3.写出或读取数据
	4. 关闭资源。
 */
public class projectNet2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(),9090);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务端你好！！".getBytes());
        socket.close();
    }
}
