import java.awt.*;

public class Face extends Frame {
	TextArea ta;
	Button clientBtn, serverBtn;
	TextField tfaddress, tfport, tftype;
	Client client;
	public Face() {
        // 实例化组件
      clientBtn = new Button("客户端");
      serverBtn = new Button("服务器");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
