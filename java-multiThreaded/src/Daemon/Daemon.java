package Daemon;
public class Daemon {
    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Daemon Thread is running!");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The main Thread is ready to exit!");

    }

}
