public class main extends Thread {
    private Thread t;

    public void run() {
        Server get = new Server();
    }
    public static void main(String[] args) {
        Server getmsg = new Server();
        getmsg.start();
        SetipWindows go = new SetipWindows();
    }
}