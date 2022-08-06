package es;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadFactory;

public class ThreadFactorySimple {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            private int counter = 0;

            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "thread-pool-name " + counter++);
            }
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(threadFactory.newThread(ThreadFactorySimple::run).getName());
        }
    }

    private static void run() {
        System.out.println("Your important logic"); // Some logic
    }
}
