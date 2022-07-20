import java.util.concurrent.atomic.AtomicBoolean;

// Buffer class. Provides a way to atomically set and get the value of a buffer memory value.
public class Buffer {
    // Atomic integer in order to use machine locking capabilities.
    private volatile int number;
    private AtomicBoolean isUpdated;

    public Buffer() {
        // Using isUpdated flag, first produce then consume.
        number    = -1;
        isUpdated = new AtomicBoolean(false);
    }

    public int getNumber() {
        // continuously check whether the producer has updated the value before consuming it.
        while (!this.isUpdated.compareAndSet(true, false)) {
             // wait for flag
        }
        return number;
    }

    public void setNumber(int number) {
        // continuously check whether the consumer received the previously produced value
        while (!this.isUpdated.compareAndSet(false, true)) {
            // wait for flag
        }
        this.number = number;
    }
}
