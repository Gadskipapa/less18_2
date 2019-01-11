package phil;

import java.util.concurrent.Semaphore;

public class Phil extends Thread {
    Semaphore sem;
    int num = 1;
    int id;

    public Phil(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try{
            while(num<3){
                sem.acquire();
                System.out.println("ФИл " +  id+ " садится за стол");
                sleep(500);
                num++;

                System.out.println("ФИл " + id + " выходит изза стола");
                sem.release();
                sleep(500);
            }
        } catch(InterruptedException e){
            System.out.println("У философа проблемы");
        }
    }
}
