import java.net.*;
import java.io.*;

public class Server extends Thread {
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public String runn() {
        try {
            Socket server = serverSocket.accept();
            DataInputStream in = new DataInputStream(server.getInputStream());
            String text = in.readUTF();
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("OK");
            server.close();
            return text;
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            return "error";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

}