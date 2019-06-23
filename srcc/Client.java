import java.net.*;
import java.io.*;

public class Client implements java.io.Serializable {

    private String peerClientAddr = "8.8.8.8";
    final private int peerClientPort = 88;

    public Client(String peerClientAddr) {
        this.peerClientAddr = peerClientAddr;
    }

    public int sendMessage(String text) throws IOException {
        if (this.peerClientAddr == "8.8.8.8") {
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
        System.out.println(this.peerClientAddr);
        System.out.println(this.peerClientPort);
    }
}