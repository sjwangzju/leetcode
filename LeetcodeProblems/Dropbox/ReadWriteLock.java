package Dropbox;

public class ReadWriteLock {

    private int readers;
    private int writers;
    private int writeRequests;

    public ReadWriteLock() {
        this.readers = 0;
        this.writers = 0;
        this.writeRequests = 0;
    }

    public synchronized void readLock() throws InterruptedException {
        while (writers > 0 || writeRequests > 0) {
            wait();
        }
        readers++;
    }

    public synchronized void writeLock() throws InterruptedException {
        writeRequests++;
        while (readers > 0 || writers > 0) {
            wait();
        }
        writeRequests--;
        writers++;
    }

    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }

    public synchronized void unlockWrite() throws InterruptedException {
        writers--;
        notifyAll();
    }
}
