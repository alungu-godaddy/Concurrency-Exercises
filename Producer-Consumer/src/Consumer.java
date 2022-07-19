import java.lang.Runnable;

// Consumer class reads values from buffer.
public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long value = buffer.getNumber();

            System.out.println("Number consumed: " + value);
        }
    }
}
