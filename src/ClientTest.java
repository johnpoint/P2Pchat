import java.io.IOException;

public class ClientTest {

    public static void main(String[] args) throws IOException {
        Client test = new Client("127.0.0.1");
        test.debug();
        test.sendMessage("this is a test message");
    }
}