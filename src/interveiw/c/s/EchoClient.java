package interveiw.c.s;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @Class: EchoClient
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/3
 */
public class EchoClient {
    private Socket socket;

    public EchoClient(Socket socket) {
        System.out.println("正在尝试连接服务端……"+ socket.getInetAddress());
        this.socket = socket;
        System.out.println("与服务端连接成功");
    }


    public void start(){
        /*
         * 当客户端启动后，就启动接收服务端发送过来消息的线程
         */
        ServerHandler handler = new ServerHandler();
        new Thread(handler).start();

        Scanner scan = new Scanner(System.in);
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osWriter = new OutputStreamWriter(out, "utf-8");

            PrintWriter writer = new PrintWriter(osWriter, true);
            System.out.println("客户端输入信息：");
            while (true)
            {
                String msg = scan.nextLine();

                /*
                 * 使用println()而不是write()， println()会调用一个newline()
                 * print()和write()类似，PrintWriter的flush()方法是继承父类，未做任何事。
                 */
                writer.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerHandler implements Runnable{

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, "utf-8");

                BufferedReader reader = new BufferedReader(isr);
                String msg;
                while ((msg = reader.readLine()) != null)
                {
                    System.out.println(msg);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6789)) {
            EchoClient client = new EchoClient(socket);
            client.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
