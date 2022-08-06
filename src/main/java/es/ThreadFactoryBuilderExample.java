package es;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ThreadFactoryBuilderExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Thread name-%d")
                .setDaemon(true)
                .build();

        for (int i = 0; i < 3; i++) {
            System.out.println(threadFactory.newThread(new Runnable() { // Thread name-0
                @Override                                               // Thread name-1
                public void run() {                                     // Thread name-2
                    // Some logic
                }
            }).getName());
        }
    }
}
