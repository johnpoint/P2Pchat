import java.net.*;
import java.io.*;
public class Clients extends Thread {
	    Socket skt;                                  // ���ڿͻ��˵�����
	    String peerClientAddr;                        // ������ַ
	    int peerClientPort;   // �˿ں�
	    Face chat;
	    String readin;
	    BufferedReader theInputStream;
	    PrintStream theOutputStream;
	    public Clients(String ip,int p){
	    peerClientAddr=ip;
		peerClientPort=p;
	    }
	    public void run() {
	        try {
	            chat.ta.append("׼�����ߣ��Ժ�");
	            skt = new Socket(peerClientAddr,peerClientPort );                     // �½�Socket����
	            chat.ta.append("�ɹ�\n");                   
	            theInputStream = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	            theOutputStream = new PrintStream(skt.getOutputStream());
	            while (true) {
	                readin = theInputStream.readLine();
	                chat.ta.append(readin + "\n");
	            }
         }catch(SocketException e){
        	 chat.ta.append("δ���ϣ�\n");
             chat.clientBtn.setEnabled(true);
             chat.serverBtn.setEnabled(true);
             chat.tfaddress.setEnabled(true);
             chat.tfport.setEnabled(true);
} catch (IOException e) {
			e.printStackTrace();
		} 
         try {
             skt.close();
         } catch (IOException err) {
             chat.ta.append(err.toString());
         }
    
     }
 
     public void dataout(String out) {
    	 theOutputStream.println(out);
  }
}