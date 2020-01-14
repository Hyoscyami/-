package chapter4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xusf
 * @Date 2020/1/14 9:59
 * @Description : 一个lock和多个condition的情况
 */
public class TestLock3 {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    /**
     * 和synchronized相比的话，synchronized只有一个condition
     */
    public void awaitA() {
        lock.lock();
        System.out.println("开始进入awaitA方法，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        try {
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println("执行awaitA方法完毕，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
    }

    public void awaitB() {
        lock.lock();
        System.out.println("开始进入awaitB方法，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        try {
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println("执行awaitB方法完毕，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
    }

    public void signalA() {
        lock.lock();
        System.out.println("开始进入signalA方法，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        conditionA.signalAll();
        lock.unlock();
        System.out.println("已发送给conditionA唤醒信号，执行signalA方法完毕，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
    }

    public void signalB() {
        lock.lock();
        System.out.println("开始进入signalB方法，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        conditionB.signalAll();
        lock.unlock();
        System.out.println("已发送给conditionB唤醒信号，执行signalA方法完毕，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
    }
}