package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
//1.使用线程池方式
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<100000;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        //手动创建线程
//        for (int i =0;i<100000;i++){
//            Thread thread = new Thread(){
//                @Override
//                public  void run(){
//                    list.add(random.nextInt());
//                }
//            };
//            thread.start();
//            thread.join();
//        }
        System.out.println("时间："+(System.currentTimeMillis()-start));
        System.out.println("大小："+list.size());
    }

}