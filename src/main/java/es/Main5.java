package es;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main5 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(() -> System.out.println("Hello Educative"));
        if(!singleThreadExecutor.isTerminated()){
            singleThreadExecutor.shutdown();
            if(singleThreadExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Executor service terminated successfully.");
            } else {
                System.out.println("Executor service termination unsuccessful.");
            }
        }
    }
}
