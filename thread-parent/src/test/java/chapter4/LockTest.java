package chapter4;

import org.junit.Test;

public class LockTest {
    /**
     * 测试lock基本用法，lock()和unlock()
     */
    @Test
    public void test(){
        TestLock testLock = new TestLock();
        TestLockThread testLockThread = new TestLockThread(testLock);
        TestLockThread2 testLockThread2 = new TestLockThread2(testLock);
        testLockThread.start();
        testLockThread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试lock的condition如何等待和被唤醒
     * 其实condition的await就是Object的wait
     * condition的await(long timeout)就是Object的wait(long timeout)
     * condition的signal就是Object的notify
     * condition的signalAll就是Object的notifyAll
     */
    @Test
    public void test2(){
        TestLock2 testLock2 = new TestLock2();
        TestLockThread3 testLockThread3 = new TestLockThread3(testLock2);
        testLockThread3.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testLock2.signal();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
