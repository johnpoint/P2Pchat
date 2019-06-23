import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JFrame;

public class Inter extends JFrame {

	private TextField tf = new TextField();
	private TextArea ta = new TextArea();

	public static void main(String[] args) throws IOException {
		new Inter();
	}

	public Inter() throws IOException {
		this.setLayout(null);
		this.setTitle("P2P Chat");
		this.setLocation(0, 0);
		this.setSize(825, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf = new TextField();
		ta = new TextArea();

		// 为TextField添加回车事件响应
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				String content = tf.getText();
				if (content != "") {
					/*
					 * 判断TextArea中是否有内容,如果有，则需要先加入一个换行符， 然后再加入内容，否则直接加入内容
					 */
					if (ta.getText().trim().length() != 0) {
						ta.setText(ta.getText() + "\n" + "you > " + content);
						Client d = null;
						try {
							FileInputStream fileIn = new FileInputStream("./peerInfo");
							ObjectInputStream in = new ObjectInputStream(fileIn);
							d = (Client) in.readObject();
							in.close();
							fileIn.close();
						} catch (IOException i) {
							i.printStackTrace();
							return;
						} catch (ClassNotFoundException c) {
							c.printStackTrace();
							return;
						}
						try {
							d.sendMessage(content);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						ta.setText("me > " + content);
					}

					tf.setText("");
				}

			}
		});
		ta.setBounds(10, 10, 800, 400);
		ta.setEnabled(false);
		tf.setBounds(10, 410, 800, 50);

		this.add(tf);
		this.add(ta);
		// pack();// 窗口自动适应大小，使窗口能正好显示里面所有的控件。
		this.setVisible(true);

		while (true) {
			Server getmsg = new Server();
			String getMsg;
			getMsg = getmsg.run();
			if (getMsg != "asjhdfgaiuwyfgfhvbiyuatefrubavwe") {
				if (ta.getText().trim().length() != 0) {
					ta.setText(ta.getText() + "\n" + " > " + getMsg);
				} else {
					ta.setText(" > " + getMsg);
				}
			}
		}

	}
}