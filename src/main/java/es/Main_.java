package es;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_ {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Runnable, return void, submit and run the task
        executor.submit(() -> System.out.println("submit Runnable."));

        // shut down the executor manually
        executor.shutdown();
    }
}
