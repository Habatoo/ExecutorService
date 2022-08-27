package es;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main2_ {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Callable<Integer>> listOfCallable = Arrays.asList(
                () -> 1,
                () -> 2,
                () -> 3);

        Integer callableInt = executor.invokeAny(listOfCallable);
        System.out.println(callableInt);

        // shut down the executor manually
        executor.shutdown();
    }
}
