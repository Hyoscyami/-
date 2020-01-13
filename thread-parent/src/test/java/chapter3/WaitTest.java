package chapter3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xusf
 * @Date 2020/1/8 14:21
 * @Description : 测试wait和notify
 */
public class WaitTest {
    /**
     * 测试单个wait和单个notify，notify以后需要等调用notify的方法执行完毕才会释放锁，所以wait后面的内容需要等notify执行完成才能执行
     * wait方法会使调用该方法的线程释放锁，然后从运行状态退出，进入等待队列，直到被再次唤醒
     */
    @Test
    public void testWait() {
        TestWait testWait = new TestWait();
        TestWait2 testWait2 = new TestWait2(testWait);
//        如果直接这么调用的话，main线程就一直要等待唤醒，下面的代码就走不下去了
//        testWait.method();
        TestWait3 testWait3 = new TestWait3(testWait);
        testWait3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testWait2.start();
    }

    /**
     * 这是先notify再wait，由于这时候没有被阻塞的线程，所以发出的notify会被忽略，最后wait的线程会一直等待
     */
    @Test
    public void testWait2() {
        TestWait testWait = new TestWait();
        TestWait2 testWait2 = new TestWait2(testWait);
        TestWait3 testWait3 = new TestWait3(testWait);
        testWait2.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testWait3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * wait必须要在先获得对象的锁以后才能调用，不然会抛出IllegalMonitorStateException异常
     */
    @Test
    public void testWait3() {
        Object object = new Object();
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试当线程在wait的时候收到中断，结果是会抛出InterruptedException异常
     */
    @Test
    public void testWait4() {
        TestWait testWait = new TestWait();
        TestWait3 testWait3 = new TestWait3(testWait);
        testWait3.start();
        testWait3.interrupt();
    }

    /**
     * 当多个线程wait的时候，执行一次notify只会随机唤醒一个线程
     */
    @Test
    public void testWait5() {
        TestWait testWait = new TestWait();
        TestWait3 testWait3 = new TestWait3(testWait);
        TestWait3 testWait31 = new TestWait3(testWait);
        testWait3.start();
        testWait31.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestWait2 testWait2 = new TestWait2(testWait);
        testWait2.start();
    }

    /**
     * 当多个线程wait的时候，执行一次notifyAll会唤醒所有线程
     */
    @Test
    public void testWait6() {
        TestWait testWait = new TestWait();
        TestWait3 testWait3 = new TestWait3(testWait);
        TestWait3 testWait31 = new TestWait3(testWait);
        testWait3.start();
        testWait31.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestWait4 testWait4 = new TestWait4(testWait);
        testWait4.start();
    }

    /**
     * 限制wait时间，测试wait(long)方法
     */
    @Test
    public void testWait7() {
        TestWait testWait = new TestWait();
        testWait.method2();
    }

    /**
     * 解决先notify再开始wait的问题
     */
    @Test
    public void testWait8() {
        TestWait5 testWait5 = new TestWait5();
        TestWait6 testWait6 = new TestWait6(testWait5);
        TestWait7 testWait7 = new TestWait7(testWait5);
        testWait6.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testWait7.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试多个线程进入wait以后都被唤醒，重复执行代码，例如多个线程都删除list导致数组越界
     */
    @Test
    public void testWait9() {
        String lock = new String("");
        List<String> list = new ArrayList<>();
        TestWait8 testWait8 = new TestWait8(lock, list);
        TestWait9 testWait9 = new TestWait9(lock, list);
        TestWait11 testWait11 = new TestWait11(testWait9);
        TestWait11 testWait111 = new TestWait11(testWait9);
        testWait11.start();
        testWait111.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestWait10 testWait10 = new TestWait10(testWait8);
        testWait10.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试单个生产者和消费者模式(其实这个示范有点跑偏了，虽然结果和生产者消费者模式一致，但是生产者和消费者并没有直接通过wait和notify通信，而是通过了共同的list)
     */
    @Test
    public void testWait10() {
        List<String> list = new ArrayList<>();
        TestWait12 testWait12 = new TestWait12(list);
        TestWait13 testWait13 = new TestWait13(list);
        TestWait14 testWait14 = new TestWait14(testWait12, list);
        TestWait15 testWait15 = new TestWait15(testWait13, list);
        testWait14.start();
        testWait15.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试单个生产者和消费者模式
     */
    @Test
    public void testWait11() {
        Object lock = new Object();
        List<String> list = new ArrayList<>();
        TestConsume testConsume = new TestConsume(lock,list);
        TestProduct testProduct = new TestProduct(lock,list);
        TestWait16 testWait16 = new TestWait16(testConsume);
        TestWait17 testWait17 = new TestWait17(testProduct);
        testWait17.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testWait16.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试多个生产者和消费者，如果只使用notify，可能会出现消费者通知消费者，生产者通知生产者的情况导致“假死”
     * 即所有线程都在等待的状态，解决办法就是讲notify改成notifyAll
     */
    @Test
    public void testWait12(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            TestWait12 testWait12 = new TestWait12(list);
            TestWait13 testWait13 = new TestWait13(list);
            TestWait14 testWait14 = new TestWait14(testWait12,list);
            TestWait15 testWait15 = new TestWait15(testWait13,list);
            testWait14.start();
            testWait15.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
