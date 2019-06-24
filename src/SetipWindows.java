import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SetipWindows extends JFrame implements ActionListener {
    JTextField inputText = new JTextField();
    JButton okeyButton = new JButton("OK");

    public SetipWindows() {
        this.setTitle("Set peer ip address");
        this.setLocation(0, 0);
        this.setSize(520, 100);
        this.setLayout(null);

        inputText.setBounds(20, 20, 400, 40);
        okeyButton.setBounds(440, 20, 70, 40);
        okeyButton.addActionListener(this);

        this.add(inputText);
        this.add(okeyButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Client peer = new Client(inputText.getText());
        try {
            FileOutputStream fileOut = new FileOutputStream("./peerInfo");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(peer);
            out.close();
            fileOut.close();
            this.dispose();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new SetipWindows();
        new Inter();
    }
}