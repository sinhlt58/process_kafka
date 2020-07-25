package ghtk.rnd.process_kafka;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    public static void main(final String[] args) throws Exception {
        for (int i=0; i<5; i++){
            executor.submit(() -> {
//                throw new Exception("Fake exception");
                try{
                    Thread.sleep(1000);
                    System.out.println("sss");
                    throw new Exception("Fake exception");
                } catch (Exception e){
                    System.out.print(("In here"));
                    throw new Exception("Fake exception");
                }
            });
        }
        Thread.sleep(2000);
        System.out.println(executor.getActiveCount());
    }
}
