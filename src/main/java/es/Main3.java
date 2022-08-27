package es;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Set<Callable<Integer>> setOfCallable = new HashSet<>();
        setOfCallable.add(() -> 1);
        setOfCallable.add(() -> 3);
        setOfCallable.add(() -> 2);

        List<Future<Integer>> futures = executor.invokeAll(setOfCallable);

        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();

    }
}
