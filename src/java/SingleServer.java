import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Scanner fromClient = null;
        PrintStream toClient = null;
        try {
            server = new ServerSocket(6666);
            System.out.println("等待客户端连接...");
            Socket client = server.accept();
            System.out.println("连接的客户端号为"+ client);
            //取得客户端的输入信息
            fromClient = new Scanner(client.getInputStream());
            //发送信息到客户端
            toClient = new PrintStream(client.getOutputStream(),true,"UTF-8");
            if(fromClient.hasNext())
                System.out.println("客户端的信息："+ fromClient.nextLine());
            toClient.println("i am ServerSocket");
            System.out.println("本地端口" + server.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            server.close();
            fromClient.close();
            toClient.close();
        }
    }
}
