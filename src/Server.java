import java.net.*;
import java.io.*;

public class Server  {
    private ServerSocket serverSocket;

    public Server() throws IOException {
        serverSocket = new ServerSocket(5118);
        serverSocket.setSoTimeout(10000);
    }

    public String run() {
        try {
            Socket server = serverSocket.accept();
            DataInputStream in = new DataInputStream(server.getInputStream());
            String text = in.readUTF();
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("OK");
            server.close();
            return text;
        } catch (SocketTimeoutException s) {
            return "asjhdfgaiuwyfgfhvbiyuatefrubavwe";
        } catch (IOException e) {
            e.printStackTrace();
            return "asjhdfgaiuwyfgfhvbiyuatefrubavwe";
        }
    }

}