package es;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AwaitTerminationExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.execute(() ->
                    System.out.println("Thread running in: " + Thread.currentThread()));
            // Thread running in: Thread[pool-1-thread-3,5,main]
            // Thread running in: Thread[pool-1-thread-2,5,main]
            // Thread running in: Thread[pool-1-thread-1,5,main]
        }
        executor.shutdown();                                      // Disable new tasks from being submitted

        try {
            if (!executor.awaitTermination(10, SECONDS)) {     // Wait 10 second for existing tasks to terminate
                executor.shutdownNow();                           // Cancel currently executing tasks
                if (!executor.awaitTermination(60, SECONDS))   // Wait 10 seconds for tasks to respond of cancelling
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();                               // Cancel if current thread also interrupted
            Thread.currentThread().interrupt();                   // Preserve interrupt status
        }

    }
}