import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {

    public static void main(String[] args) throws IOException {
        Socket client = null;
        Scanner fromServer = null;
        PrintStream toServer = null;
        try {
            client = new Socket("127.0.0.1",6666);
            fromServer = new Scanner(client.getInputStream());
            toServer = new PrintStream(client.getOutputStream(),true,"UTF-8");
            toServer.println("i am client");
            if(fromServer.hasNext())
                System.out.println("服务器的信息：" + fromServer.nextLine());
            System.out.println("远程端口"+ client.getPort());
            System.out.println("本地端口" + client.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            client.close();
            fromServer.close();
            toServer.close();
        }

    }
}
