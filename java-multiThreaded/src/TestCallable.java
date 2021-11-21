import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 86171
 * 通过实现 Callable 接口实现线程，返回 String 类型数据
 */
public class TestCallable{


    public static <MyCallable> void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo mc = new CallableDemo();
        FutureTask<String> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}

class CallableDemo implements Callable<String>{
    @Override
    public String call(){
        //...
        return "线程执行结束";
    }
}

