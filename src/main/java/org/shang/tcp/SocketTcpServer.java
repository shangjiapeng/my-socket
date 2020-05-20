package org.shang.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

/**
 * @Author: shangjp
 * @Email: shangjp@163.com
 * @Date: 2020/5/17 22:36
 * @Description:
 */
public class SocketTcpServer {

    public static void main(String[] args) throws IOException {
        //创建server socket
        ServerSocket serverSocket = new ServerSocket();
        //创建socket监听链接地址和端口号
        SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 8080);
        //绑定我们监听的地址
        serverSocket.bind(address);
        //等待接收请求,当前程序就会实现阻塞
        System.out.println("等待客户端发送消息...");
        Socket accept = serverSocket.accept();
        //获取OutputStream输出流
        PrintWriter socketOut = new PrintWriter(accept.getOutputStream());
        byte[] buf = new byte[2014];
        if (accept.getInputStream().read(buf) > 0) {
            System.out.println("服务器接受到客户端的请求:" + new String(buf));
        }
        //向客户端回复的内容
        String sendStr = "不好意思这个周末,我约了别人打游戏.";
        socketOut.write(sendStr);
        socketOut.flush();

        //使用完之后关闭链接
        socketOut.close();
        accept.close();
        serverSocket.close();
    }


}
