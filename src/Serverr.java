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
    private ServerSocket serverSocket;

    public Serverr(Inter chat) throws IOException {
        this.chat = chat;
        serverSocket = new ServerSocket(5117);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                System.out.println(i);
                Socket sserver = serverSocket.accept();
                DataInputStream in = new DataInputStream(sserver.getInputStream());
                chat.ta.setText(chat.ta.getText() + "\n" + " > " + in.readUTF());
                sserver.close();
            } catch (SocketTimeoutException s) {
            } catch (IOException f) {
            }
            i++;
        }

    }

    public void start() {
        t = new Thread(this);
        t.start();
    }

}