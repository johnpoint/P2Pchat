import java.net.*;
import java.io.*;

public class Client {

    private String peerClientAddr = "0.0.0.0";
    final private int peerClientPort = 5118;

    public Client(String peerClientAddr) {
        this.peerClientAddr = peerClientAddr;
    }

    public int sendMessage(String text) {
        if (this.peerClientAddr == "0.0.0.0") {
            return 1;
        }
        Socket client = new Socket(this.peerClientAddr, peerClientPort);
        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.writeUTF(text);
        InputStream inFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        System.out.println(in.readUTF());
        client.close();
        return 0;
    }

    public void debug() {
        System.out.println(peerClientAddr);
        System.out.println(peerClientPort);
    }
}