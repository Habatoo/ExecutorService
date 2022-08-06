package es;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableSubmitExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(() -> {
            System.out.println("Runnable task"); // Runnable task
        });

        System.out.println("Runnable result " + future.get()); // Runnable result null
        // returns null if the task is finished correctly.
    }
}
