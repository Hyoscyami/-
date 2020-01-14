package chapter4;

import org.junit.Test;

/**
 * @Author xusf
 * @Date 2020/1/14 9:35
 * @Description : 可重入锁Lock相关用法
 */
public class LockTest {
    /**
     * 测试lock基本用法，lock()和unlock()
     */
    @Test
    public void test() {
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
    public void test2() {
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

    /**
     * 测试一个lock和多个condition
     */
    @Test
    public void test3() {
        TestLock3 testLock3 = new TestLock3();
        TestLockThread4 testLockThread4 = new TestLockThread4(testLock3);
        TestLockThread5 testLockThread5 = new TestLockThread5(testLock3);
        TestLockThread6 testLockThread6 = new TestLockThread6(testLock3);
        TestLockThread7 testLockThread7 = new TestLockThread7(testLock3);
        testLockThread4.start();
        testLockThread5.start();
        testLockThread6.start();
        testLockThread7.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testLock3.signalA();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * lock和单个生产者和消费者
     */
    @Test
    public void test5() {
        TestLock4 testLock4 = new TestLock4();
        TestLockThread8 testLockThread8 = new TestLockThread8(testLock4);
        TestLockThread9 testLockThread9 = new TestLockThread9(testLock4);
        testLockThread8.start();
        testLockThread9.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * lock和多个生产者和消费者
     */
    @Test
    public void test6(){
        TestLock5 testLock5 = new TestLock5();
        for (int i = 0; i < 2; i++) {
            TestLockThread10 testLockThread10 = new TestLockThread10(testLock5);
            TestLockThread11 testLockThread11 = new TestLockThread11(testLock5);
            testLockThread10.start();
            testLockThread11.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
