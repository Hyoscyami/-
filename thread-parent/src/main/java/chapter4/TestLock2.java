package chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
* @Author xusf
* @Date 2020/1/14 9:33
* @Description : lock和condition的基本用法
*/
public class TestLock2 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        lock.lock();
        System.out.println("开始进入TestLock2的await方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void signal() {
        lock.lock();
        System.out.println("开始进入TestLock2的signal方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        condition.signal();
        lock.unlock();
    }
}
