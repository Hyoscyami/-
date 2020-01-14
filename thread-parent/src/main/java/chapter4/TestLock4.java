package chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xusf
 * @Date 2020/1/14 10:41
 * @Description : lock实现的单个生产者和消费者
 */
public class TestLock4 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean flag = false;

    public void consume() {
        lock.lock();
        System.out.println("开始进入TestLock4的consume方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        while (flag) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        condition.signal();
        lock.unlock();
        System.out.println("已发送通知给product，consume结束，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
    }

    public void product() {
        lock.lock();
        System.out.println("开始进入TestLock4的product方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        while (!flag) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        condition.signal();
        lock.unlock();
        System.out.println("开始进入TestLock4的consume方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
    }
}
