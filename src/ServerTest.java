import java.io.IOException;

public class ServerTest {

    public static void main(String[] args) throws IOException {
        Server test = new Server();
        String re = test.run();
        System.out.println(re);
    }
}