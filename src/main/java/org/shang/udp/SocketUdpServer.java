package org.shang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: shangjp
 * @Email: shangjp@163.com
 * @Date: 2020/5/17 23:17
 * @Description: 服务端
 *  * 1.创建服务端+端口
 *  * 2.准备接受容器
 *  * 3.封装成包
 *  * 4.接受数据
 *  * 5.分析数据
 */
public class SocketUdpServer {

//    public static void main(String[] args) throws IOException {
//
//        /**
//         * 接收客户端发送的数据
//         */
//        //1 创建服务器端的DatagramSocket,指定端口
//        DatagramSocket server = new DatagramSocket(8080);
//        //2 创建数据组,用于接收客户端发送的数据
//        byte[] data = new byte[1024];
//        //创建字节组,指定接收的数据包的大小
//        DatagramPacket packet = new DatagramPacket(data, data.length);
//        //3接收客户端发送的数据
//        System.out.println("****服务器已启动,等待客户端发送数据***");
//        //此方法在接收到数据报之前会一直阻塞
//        server.receive(packet);
//        //读取数据
//        String info = new String(data, 0, packet.getLength());
//        System.out.println("我是服务器,客户端新消息为:" + info);
//
//
//        /**
//         * 向客户端响应数据
//         */
//        //1 定义服务器的地址,端口号,数据
//        SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 8080);
//        //2.准备数据
//        Scanner sc = new Scanner(System.in);
//        System.out.println("input send msg:");
//        String msg = sc.nextLine();
//        byte[] data2= msg.getBytes();
//
//        //2创建数据包,包含需要发送的信息
//        DatagramPacket packet2 = new DatagramPacket(data2, data2.length,address);
//        //3向服务器端发送数据报文
//        server.send(packet2);
//        //4关闭资源
//        server.close();
//    }


    public static void main(String[] args) throws IOException {
        //1.创建服务端+端口
        DatagramSocket server = new DatagramSocket(7777);
        //2.准备接受容器
        byte[] container = new byte[1024];
        //3.封装成包
        DatagramPacket packet = new DatagramPacket(container, container.length);
        //4.接受数据
        server.receive(packet);
        //5.分析数据
        byte[] data = packet.getData();
        int len = packet.getLength();
        System.out.println("server receive:"+new String(data,0,len));
        //6.释放
        server.close();
    }
}
