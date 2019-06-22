import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Inter extends Thread implements ActionListener{
     //界面名
	 private JFrame frame=new JFrame("P2P聊天");
	 //聊天信息
	 private JTextArea info=new JTextArea(15,30);
	 //在线用户
     private JTextField msgText=new JTextField(30);
	 //按钮
	 private JButton sendButton=new JButton("发送");
	 
	 //private DatagramSocket inter;
	 
	 
	 public Inter(){
	 
	  // this.inter=inter;
      //界面
	  frame.setSize(600, 400);

	  JScrollBar scroll=new JScrollBar();

	  //激活自动换行功能 
	  info.setLineWrap(true);
	  info.setWrapStyleWord(true);
	  info.setEditable(false);
	  scroll.add(info);
	   
	  JPanel infopanel=new JPanel();
	  infopanel.add(info,BorderLayout.WEST);
	  JPanel infopanel1=new JPanel();

	  infopanel.add(infopanel1,BorderLayout.EAST);
	 
	  JPanel panel=new JPanel();
	  
	 // msgText=new JTextField(30);
	 
	  panel.add(msgText);
	  panel.add(sendButton);
	  frame.add(infopanel,BorderLayout.NORTH);
	  frame.add(panel,BorderLayout.SOUTH);
	  frame.setVisible(true);
	  
	  sendButton.addActionListener(this);
	  
	  frame.addWindowListener(new   WindowAdapter(){ 
	            public   void   windowClosing(WindowEvent   e){ 
	                System.exit(0);
	            } 
	         }); 
	  
	 
	 }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Inter();
		
		
	}
	//按件系统
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	//	if(e.getSource()==this.sendButton)
	//	  {
	//	   try{
	//	    String msg=this.msgText.getText();
	//	    if(msg.length()>0)
	//	    {
	//	     this.info.append("我说："+msg);
	//	     this.info.append("\n");
	//	     for (Map.Entry<String, SocketAddress> entry : userMap.entrySet()) {
	//	      DatagramPacket data=new DatagramPacket(msg.getBytes(),msg.getBytes().length,entry.getValue());
	//.send(data);
	//	     }
		     
	//	     this.msgText.setText("");
	//	    }
	//	   }
	//	   catch(Exception ee){}
	//  }
	}

}
