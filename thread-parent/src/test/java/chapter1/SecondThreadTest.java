package chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SecondThreadTest {

    /**
     * 运行线程
     */
    @Test
    public void testRun() throws InterruptedException {
        SecondThread secondThread = new SecondThread();
        Thread thread = new Thread(secondThread);
        thread.start();
//        为了能看到执行线程后打印的结果，睡500ms
        Thread.sleep(500);
    }
    @Test
    public void testThreadName(){

    }
}