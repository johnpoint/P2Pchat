import java.net.*;
import java.io.*;

public class Client implements java.io.Serializable {

    private String peerClientAddr = "8.8.8.8";
    final private int peerClientPort = 5118;


    public Client(String peerClientAddr) {
        this.peerClientAddr = peerClientAddr;
    }

    public void sendMessage(String text) throws IOException {
        Socket client;
        OutputStream outToServer;
        DataOutputStream out;
        if (this.peerClientAddr == "8.8.8.8") {
            return;
        }
        if (this.peerClientAddr == "8.8.8.8") {
            return;
        }
        client = new Socket(this.peerClientAddr, peerClientPort);
        outToServer = client.getOutputStream();
        out = new DataOutputStream(outToServer);
        out.writeUTF(text);
        client.close();
        return;
    }

    public void debug() {
        System.out.println(this.peerClientAddr);
        System.out.println(this.peerClientPort);
    }
}