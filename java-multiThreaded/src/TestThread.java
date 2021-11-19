
public class TestThread {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("t1");
        ThreadDemo t2 = new ThreadDemo("t2");
        ThreadDemo t3 = new ThreadDemo("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class ThreadDemo extends Thread {
    public String name;
    /**
     * 可出售票数
     * 这里没有用static修饰，tickets属于每个线程的内部变量。
     * 具体就是每个线程都会卖5张票。使用static修饰则会使它成为共享资源。
     */
    public int tickets = 5;
    public static int sum = 0;

    @Override
    public void run() {

        while (tickets > 0) {
            decreseTicket();
//            sum++;
//            System.out.println(sum);
            System.out.println(name + "出售了第" + (5 - tickets) + "张票");
        }
    }

    public synchronized void decreseTicket() {
        tickets--;
    }

    public ThreadDemo(String name) {
        this.name = name;
    }
}