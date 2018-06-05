package interveiw.c.s;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class: EchoServer
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/2
 */
public class EchoServer {
    private static final int ECHO_SERVER_PORT = 6789;
    private List<PrintWriter> allOut;
    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.start();

    }

    public EchoServer() {
        allOut = new ArrayList<>();
    }

    private synchronized void addOut(PrintWriter pw){
        allOut.add(pw);
    }
    private synchronized void removeOut(PrintWriter pw){
        allOut.remove(pw);
    }
    private synchronized void sendMessageToAllClient(String m){
        for(PrintWriter pw:allOut){
            pw.println(m);
        }
    }



    public void start(){

        try (ServerSocket server = new ServerSocket(ECHO_SERVER_PORT) ) {
            System.out.println("服务器已启动...");
            while (true)
            {
                Socket client = server.accept();
                ClientHandler handler = new ClientHandler(client);

                new Thread(handler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable{
        private Socket client;
        private String host;

        public ClientHandler(Socket client) {
            this.client = client;
            //通过socket可以得知远端计算机信息
            host = client.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            PrintWriter writer = null;
            try {


                writer = new PrintWriter(
                        new OutputStreamWriter(client.getOutputStream(), "utf-8"),true);

                //共享该客户端的输出流
                addOut(writer);
                //广播该用户上线
                sendMessageToAllClient(host + " is online");

                InputStream in = client.getInputStream();
                InputStreamReader isReader = new InputStreamReader(in, "utf-8");
                BufferedReader bufReader = new BufferedReader(isReader);

                String msg;
                while ((msg = bufReader.readLine()) != null)
                {
                    sendMessageToAllClient(host + "：" + msg);
                }





            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                /*
                 * 当该客户端与服务端断开时，应当将该客户端的输出流从共享集合删除。
                 */
                allOut.remove(writer);
                if(client != null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}

