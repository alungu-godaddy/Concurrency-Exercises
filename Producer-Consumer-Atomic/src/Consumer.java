import java.lang.Runnable;

/***
 * Consumer class, prints out newly produced values. Runs on separate thread.
 */
public class Consumer implements Runnable{
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int number = this.buffer.getNumber();

            System.out.println("Number consumed: " + number);
        }
    }
}
