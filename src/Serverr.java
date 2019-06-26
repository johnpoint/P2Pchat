import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Serverr extends Thread {
    private Thread t;
    Inter chat;

    DataInputStream in;
    DataOutputStream out;

    public Serverr(Inter chat) {
        this.chat = chat;
    }

    public void run() {
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(5117);
                serverSocket.setSoTimeout(10000);
                Socket sserver = serverSocket.accept();
                DataInputStream in = new DataInputStream(sserver.getInputStream());
                chat.ta.setText(chat.ta.getText() + "\n" + " > " + in.readUTF());
                sserver.close();
            } catch (SocketTimeoutException s) {
            } catch (IOException f) {
            }
        }

    }

    public void start() {
        t = new Thread(this);
        t.start();
    }

}