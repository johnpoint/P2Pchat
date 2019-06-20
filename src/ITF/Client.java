import java.net.*;
import java.io.*;

public class Client {

    private String peerClientAddr;
    final private String peerClientPort = "5118";

    public Client(String peerClientAddr) {
        this.peerClientAddr = peerClientAddr;
    }

    /*public void sendMessage(String text){

    }*/

    public void debug(){
        System.out.println(peerClientAddr);
        System.out.println(peerClientPort);
    }
}