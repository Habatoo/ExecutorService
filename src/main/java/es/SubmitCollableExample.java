package es;

import java.util.concurrent.*;

public class SubmitCollableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit((Callable) () -> {
            System.out.println("Asynchronous callable");  // Asynchronous callable
            return "Callable Result";
        });

        System.out.println("Future: " + future.get());  // Future: Callable Result
    }
}