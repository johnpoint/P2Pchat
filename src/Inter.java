import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Inter extends JFrame implements ActionListener {
	private TextField tf = new TextField();
	private TextField ipaddr = new TextField();
	private TextArea ta = new TextArea();
	private JButton setipButton = new JButton();
	private JLabel peeripaddr = new JLabel("对方 IP: ");
	private ServerSocket serverSocket;
	public Client d;

	public static void main(String[] args) throws IOException {
		new Inter();
	}

	public Inter() throws IOException {

		this.setLayout(null);
		this.setTitle("P2P Chat");
		this.setLocation(0, 0);
		this.setSize(825, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		tf = new TextField();
		ta = new TextArea();
		serverSocket = new ServerSocket(5118);
		serverSocket.setSoTimeout(1000000);
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Client d = null;
				try {
					FileInputStream fileIn = new FileInputStream("./peerInfo");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					d = (Client) in.readObject();
					in.close();
					fileIn.close();
					//d.sendMessage("Client Hello");
				} catch (IOException i) {
					i.printStackTrace();
					//return;
				} catch (ClassNotFoundException c) {
					c.printStackTrace();
					//return;
				}
				String content = tf.getText();
				if (content != "") {
					/*
					 * 判断TextArea中是否有内容,如果有，则需要先加入一个换行符， 然后再加入内容，否则直接加入内容
					 */
					if (ta.getText().trim().length() != 0) {
						ta.setText(ta.getText() + "\n" + "you > " + content);

						try {
							d.sendMessage(content);
						} catch (IOException e) {
							e.printStackTrace();
						}

					} else {
						ta.setText("you > " + content);
					}

					tf.setText("");
				}
			}
		});
		ta.setBounds(10, 110, 800, 400);
		tf.setBounds(10, 510, 800, 50);
		ipaddr.setBounds(10, 55, 700, 50);
		setipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client peer = new Client(ipaddr.getText());
				try {
					FileOutputStream fileOut = new FileOutputStream("./peerInfo");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(peer);
					out.close();
					fileOut.close();
				} catch (IOException i) {
					i.printStackTrace();
				}
				peeripaddr.setText("对方 IP: "+ipaddr.getText());
				ipaddr.setText("");
				ta.setText("");
			}
		});
		setipButton.setBounds(720, 55, 85, 50);
		setipButton.setText("link");
		peeripaddr.setBounds(10, 10, 800, 50);
		this.add(tf);
		this.add(ta);
		this.add(setipButton);
		this.add(ipaddr);
		this.add(peeripaddr);
		this.setVisible(true);
		while (true) {
			try {
				Socket server = serverSocket.accept();
				DataInputStream in = new DataInputStream(server.getInputStream());
				ta.setText(ta.getText() + "\n" + " > " + in.readUTF());
				server.close();
			} catch (SocketTimeoutException s) {
				ta.setText(ta.getText() + "\n" + "## 链接丢失");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}