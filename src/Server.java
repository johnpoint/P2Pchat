import java.net.*;
import java.io.*;

public class Server extends Thread implements java.io.Serializable  {
    private Thread t;
    private ServerSocket serverSocket;
    public String waitMessage = "";

    public Server() throws IOException {
        serverSocket = new ServerSocket(5111);
        serverSocket.setSoTimeout(1000000);
    }

    public void run() {
        try {
            Socket server = serverSocket.accept();
            DataInputStream in = new DataInputStream(server.getInputStream());
            this.waitMessage+= "\n > "+in.readUTF();
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("OK");
            server.close();
        } catch (SocketTimeoutException s) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessage(){
        String returnMessage = this.waitMessage;
        this.waitMessage="";
        return returnMessage;
    }

    public void start(){
        t = new Thread(this);
        t.start();
    }

}