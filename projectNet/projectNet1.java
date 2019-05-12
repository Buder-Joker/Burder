package projectNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class projectNet1 {
    public static void main(String[] args) throws UnknownHostException {
        //getLocalHost()获取本机的IP地址
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("IP地址："+address.getHostAddress());
        //getHostName()获取本机的主机名
        System.out.println("主机名："+address.getHostName());

        //获取别人机器的IP地址对象
        //可以很根据一个主机名或是IP地址的字符串获取到一个IP对象
        InetAddress address1 = InetAddress.getByName("192.168.73.1");
        InetAddress address2 = InetAddress.getByName("Lenovo-PC");
        System.out.println("IP地址："+address1.getHostAddress());
        System.out.println("主机名："+address1.getHostAddress());
        System.out.println();
        System.out.println("IP地址："+address2.getHostAddress());
        System.out.println("主机名："+address2.getHostAddress());

    }
}
