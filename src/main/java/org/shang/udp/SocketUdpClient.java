package org.shang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @Author: shangjp
 * @Email: shangjp@163.com
 * @Date: 2020/5/17 23:17
 * @Description:客户端
 *  * 1.创建客户端+端口
 *  * 2.准备数据
 *  * 3.打包（发送的地点及端口）
 *  * 4.发送
 */
public class SocketUdpClient {

//    public static void main(String[] args) throws IOException {
//        /**
//         * 向服务器端发送数据
//         */
//        //1.创建客户端+端口
//        DatagramSocket client = new DatagramSocket(5555);
//        //2.准备数据
//        Scanner sc = new Scanner(System.in);
//        System.out.println("input send msg:");
//        String msg = sc.nextLine();
//        byte[] data = msg.getBytes();
//        //3.打包（发送的地点及端口）
//        DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",7777));
//        //4.发送
//        client.send(packet);
//        /**
//         * 接收服务端响应的数据
//         */
//        //1创建数据报,用于接收服务器端响应的数据
//        byte[] data2 = new byte[1024];
//        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
//        //2接收服务器端响应的数据
//        client.receive(packet2);
//        //3读书数据
//        String reply =new String(data2 ,0 ,packet2.getLength());
//        System.out.println("我是客户端服务器回答说:"+reply);
//        //4关闭资源
//        client.close();
//
//    }

    public static void main(String[] args) throws IOException {
        //1.创建客户端+端口
        DatagramSocket client = new DatagramSocket(5555);
        //2.准备数据
        Scanner sc = new Scanner(System.in);
        System.out.println("input send msg:");
        String msg = sc.nextLine();
        byte[] data = msg.getBytes();
        //3.打包（发送的地点及端口）
        DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",7777));
        //4.发送
        client.send(packet);
        //5.释放
        client.close();

    }


}
