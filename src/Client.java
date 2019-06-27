import java.net.*;
import java.io.*;

public class Client extends Thread {
    private Thread t;
    public Inter chat;
    public String Text;

    private String peerClientAddr = "8.8.8.8";
    final private int peerClientPort = 5117;

    public Client(String peerClientAddr, Inter chat) {
        this.peerClientAddr = peerClientAddr;
        this.chat = chat;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public void run() {
        Socket client;
        OutputStream outToServer;
        DataOutputStream out;
        if (this.peerClientAddr == "8.8.8.8") {
            chat.ta.setText(chat.ta.getText() + "\n" + "发送失败，可能对方不在线");
            return;
        }
        try {
            client = new Socket(this.peerClientAddr, peerClientPort);
            outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);
            out.writeUTF(this.Text);
            client.close();
            return;
        } catch (IOException e) {
            chat.ta.setText(chat.ta.getText() + "\n" + "发送失败，可能对方不在线");
            return;
        }
    }

    public void start() {
        t = new Thread(this);
        t.start();
    }

    public void debug() {
        System.out.println(this.peerClientAddr);
        System.out.println(this.peerClientPort);
    }
}