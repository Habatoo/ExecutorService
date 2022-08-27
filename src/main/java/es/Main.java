package es;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Callable, return a future, submit and run the task
        Future<String> callableTask = executor.submit(() -> {
            System.out.println("submit Callable.");
            return "Callable";
        });

        // block until future returned a result,
        String result = callableTask.get();
        System.out.println("Get result : " + result);

        // shut down the executor manually
        executor.shutdown();
    }
}
