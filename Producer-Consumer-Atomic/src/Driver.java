import java.lang.Thread;

public class Driver {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
