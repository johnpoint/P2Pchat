import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Inter extends JFrame implements ActionListener {
	public TextField tf = new TextField();
	public TextField ipaddr = new TextField();
	public TextArea ta = new TextArea();
	public JButton setipButton = new JButton();
	public JLabel peeripaddr = new JLabel("对方 IP: ");

	public Client d;
	public JMenuBar menuBar = new JMenuBar();
	public static Inter frm;

	public static void main(String[] args) throws IOException {
		frm = new Inter();
		Serverr server = new Serverr(frm);
		server.start();
	}

	public Inter() throws IOException {
		this.setJMenuBar(menuBar);
		JMenu menu1 = new JMenu("关于");
		JMenuItem item1 = new JMenuItem("help");
		JMenuItem item2 = new JMenuItem("LICENSE");
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		menu1.add(item1);
		menu1.add(item2);
		menuBar.add(menu1);
		this.setLayout(null);
		this.setTitle("P2P Chat");
		this.setLocation(0, 0);
		this.setSize(825, 575);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		tf = new TextField();
		ta = new TextArea();
		ServerSocket serverSocket = new ServerSocket(5118);
		serverSocket.setSoTimeout(1000000);
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				
				String content = tf.getText();
				if (content != "") {
					if (ta.getText().trim().length() != 0) {
						ta.setText(ta.getText() + "\n" + "you > " + content);

						try {
							d.sendMessage(content);
						} catch (IOException e) {
							e.printStackTrace();
						}

					} else {
						try {
							d.sendMessage(content);
						} catch (IOException e) {
							e.printStackTrace();
						}
						ta.setText("you > " + content);
					}
					

					tf.setText("");
				}
			}
		});
		ta.setBounds(10, 65, 800, 400);
		tf.setBounds(10, 465, 800, 50);
		ipaddr.setBounds(60, 10, 700, 50);
		//perport.setBounds(530, 10,50, 50);
		//setport.setBounds(560, 10, 150, 50);
		setipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client peer = new Client(ipaddr.getText());
				d = peer;
				peeripaddr.setText("对方 IP: " + ipaddr.getText());
				ta.setText("");
				ipaddr.setEnabled(false);
				ta.setText("已经准备就绪");
			}
		});

		setipButton.setBounds(720, 10, 85, 50);
		setipButton.setText("link");
		peeripaddr.setBounds(10, 10, 800, 50);
		this.add(tf);
		this.add(ta);
		this.add(setipButton);
		this.add(ipaddr);
		this.add(peeripaddr);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}