import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86171
 */

class myThread implements Runnable{
    Thread t;
    private String name;

    public myThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name +"开炮！！！！");



    }

    public void start(){
        System.out.println("Creating"+name);
        if (t==null){
            this.t = new Thread(this);
            t.start();
        }
    }
}
class RunnableDemo extends Thread {
    private Thread t;
    private String threadName;

    private static  int tickets = 100;
    private static  int sum =0;
    private Lock ticketsLock = new ReentrantLock();

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public  void  run() {

        System.out.println("Running " + threadName);
                while (tickets > 0) {
                    ticketsLock.lock();
                    try {
                        tickets--;
                        System.out.println(sum);
                        System.out.println("Thread: " + threadName + ",抢了第 "+(100-tickets) +"张票,"+"剩余：" + tickets + "张票");
                        // 模拟网络延迟
                        int delay =(int) (Math.random()*10);
                        Thread.sleep(delay);
                    } catch (Exception e) {
                        System.out.println("Thread " + threadName + " interrupted.");
                    }
                    finally {
                        ticketsLock.unlock();
                    }
                }


        System.out.println("Thread " + threadName + " exiting.");
    }


    @Override
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThread {

    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();

        RunnableDemo R3 = new RunnableDemo("Thread-3");
        R3.start();

        RunnableDemo R4 = new RunnableDemo("Thread-4");
        R4.start();

        RunnableDemo R5 = new RunnableDemo("Thread-5");
        R5.start();

        RunnableDemo R6 = new RunnableDemo("Thread-6");
        R6.start();

        RunnableDemo R7 = new RunnableDemo("Thread-7");
        R7.start();

        RunnableDemo R8 = new RunnableDemo("Thread-8");
        R8.start();
        myThread myThread1 = new myThread("线程一号");
        myThread1.start();
        myThread myThread2 = new myThread("线程二号");
        myThread2.start();

    }
}