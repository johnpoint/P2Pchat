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
     //������
	 private JFrame frame=new JFrame("P2P����");
	 //������Ϣ
	 private JTextArea info=new JTextArea(15,30);
	 //�����û�
     private JTextField msgText=new JTextField(30);
	 //��ť
	 private JButton sendButton=new JButton("����");
	 
	 //private DatagramSocket inter;
	 
	 
	 public Inter(){
	 
	  // this.inter=inter;
      //����
	  frame.setSize(600, 400);

	  JScrollBar scroll=new JScrollBar();

	  //�����Զ����й��� 
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
	//����ϵͳ
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	//	if(e.getSource()==this.sendButton)
	//	  {
	//	   try{
	//	    String msg=this.msgText.getText();
	//	    if(msg.length()>0)
	//	    {
	//	     this.info.append("��˵��"+msg);
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
