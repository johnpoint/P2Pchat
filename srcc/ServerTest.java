import java.io.IOException;

public class ServerTest {

    public static void main(String[] args) throws IOException {
        Server test = new Server(5118);
        String re = test.runn();
        System.out.println(re);
    }
}