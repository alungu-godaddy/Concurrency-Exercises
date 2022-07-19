
// This is the buffer class, which represents the critical section for the
// producer-consumer threads.
public class Buffer {
    private volatile long number = -1; // Notice that operations on long values are non-atomic.

    private boolean available = false; // flag used to notify if new data has been produced

    public synchronized long getNumber() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        available = false;
        notifyAll(); // wake up producer
        return number;
    }

    public synchronized void setNumber(int number) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        available = true;
        this.number = number;
        notifyAll(); // wake up consumer
    }
}
