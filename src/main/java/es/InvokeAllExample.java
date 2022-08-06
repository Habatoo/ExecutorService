package es;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class InvokeAllExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(() -> "First task");
        callables.add(() -> "Second task");

        List<Future<String>> futures = executorService.invokeAll(callables);
        for (Future<String> future : futures) {
            System.out.println("Future: " + future.get()); // Future: First task
            // Future: Second task
        }

        executorService.shutdown();
    }
}
