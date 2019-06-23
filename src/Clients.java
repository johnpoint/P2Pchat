import java.net.*;
import java.io.*;
public class Clients extends Thread {
	    Socket skt;                                  // 用于客户端的连接
	    String peerClientAddr;                        // 主机地址
	    int peerClientPort;   // 端口号
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
	            chat.ta.append("准备连线，稍后！");
	            skt = new Socket(peerClientAddr,peerClientPort );                     // 新建Socket对象
	            chat.ta.append("成功\n");                   
	            theInputStream = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	            theOutputStream = new PrintStream(skt.getOutputStream());
	            while (true) {
	                readin = theInputStream.readLine();
	                chat.ta.append(readin + "\n");
	            }
         }catch(SocketException e){
        	 chat.ta.append("未连上！\n");
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