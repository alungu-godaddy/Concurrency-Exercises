import java.lang.Runnable;
import java.lang.Thread;

import java.lang.InterruptedException;

// Producer class, creates new integer value and then sets it into the buffer;
public class Producer implements Runnable{
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.buffer.setNumber(i);
            System.out.println("Number produced: " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
