package chapter1;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static org.junit.Assert.*;

public class ThirdThreadTest {
    @Test
    public void testRun() throws ExecutionException, InterruptedException {
        ThirdThread thirdThread = new ThirdThread();
        FutureTask<Integer> task = new FutureTask<>(thirdThread);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }
}