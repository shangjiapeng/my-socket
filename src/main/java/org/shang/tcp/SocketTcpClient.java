package org.shang.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 * @Author: shangjp
 * @Email: shangjp@163.com
 * @Date: 2020/5/17 22:27
 * @Description:
 */
public class SocketTcpClient {

    public static void main(String[] args) throws IOException {
        //创建socket
        final Socket socket = new Socket();
        //创建socket地址
        SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 8080);
        socket.connect(address);
        //创建printWriter
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
        BufferedReader socketIn = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        //向服务器发送的内容
        String sendStr = "客户端向服务器发送: 请问你周末有空吗 ";
        socketOut.write(sendStr);
        socketOut.flush();
        //等待服务器的响应
        String receiverStr = socketIn.readLine();
        System.out.println("服务端回复:" + receiverStr);

        //使用完之后关闭链接
        socketOut.close();
        socketIn.close();
        socket.close();
    }
}
