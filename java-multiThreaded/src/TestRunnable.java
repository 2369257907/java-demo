/**
 * @author 86171
 * 通过实现Runnable接口实现线程
 */
public class TestRunnable {
    public static void main(String[] args) {
        //只实现了一个Runnable接口，两个线程实际上指向同一个对象，所以只会卖出5张票(没有考虑线程同步的问题)
        RunnableDemo runnableDemo = new RunnableDemo("runnnableDemo");
        Thread r1 = new Thread(runnableDemo);
        Thread r2 = new Thread(runnableDemo);
        r1.start();
        r2.start();
    }
}

class RunnableDemo implements Runnable {
    private int tickets = 5;
    private String name;

    @Override
    public void run() {
        while (tickets > 0) {
            tickets--;
            System.out.println(name + ":售出了第" + (5 - tickets) + "张票");
        }
    }

    public RunnableDemo(String name) {
        this.name = name;
    }
}