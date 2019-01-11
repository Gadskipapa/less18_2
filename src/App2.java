import java.util.concurrent.locks.ReentrantLock;

class App2 {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(commonResource, locker));
            t.setName("Поток "+i);
            t.start();
        }
    }
}
