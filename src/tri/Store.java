package tri;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Store {
    int product = 0;
    ReentrantLock locker;
    Condition condition;

    public Store() {
        this.locker = locker;
        this.condition = condition;
    }

    void get() {
        try {
            locker.lock();
            while (product < 1) {
                condition.await();
                product--;
                System.out.println("Pokupatel kupil tovar");
                System.out.println("Товаров на складе " +product);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    void put() {
        try {
            locker.lock();
            while (product >= 3) {
                condition.await();
                product++;
                System.out.println("Proizvoditel dobavil tovar");
                System.out.println("Товаров на складе " +product);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}