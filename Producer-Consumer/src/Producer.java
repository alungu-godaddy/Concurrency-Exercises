import java.lang.Runnable;
import java.lang.Thread;
import java.lang.Math;

import java.lang.InterruptedException;

// Producer object generates numbers and puts them into the buffer.
public class Producer implements Runnable{
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.setNumber(i);
            System.out.println("Number produced: " + i);

            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
