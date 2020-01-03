package chapter1;

import org.junit.Test;

public class FirstThreadTest {
    /**
     * 运行线程
     */
    @Test
    public void testRun() throws InterruptedException {
        FirstThread thread = new FirstThread();
        thread.start();
//        为了能看到执行线程后打印的结果，睡500ms
        Thread.sleep(500);
    }

    /**
     * 打印线程名
     */
    @Test
    public void testThreadName() throws InterruptedException {
        FirstThread  thread = new FirstThread();
        thread.setName("FirstThread");
        thread.start();
        //        为了能看到执行线程后打印的结果，睡500ms
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName());
    }
}