package chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
* @Author xusf
* @Date 2020/1/14 9:33
* @Description : lock基本用法
*/
public class TestLock {
    private Lock lock = new ReentrantLock();

    public void method() {
//        这里其实就和synchronized代码块效果一样，不过如果出现了异常可能会导致没有释放锁，所以一般是在finally里面释放锁，当然，这里可能出现的异常
//        就中断异常，已经被捕获了，不会影响到锁的释放
        lock.lock();
        System.out.println("开始进入同步块，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        就比如这种情况，这里抛异常了，其他线程也一直不能执行这个方法了，因为获取不到锁
//        Integer.parseInt("s");
        lock.unlock();
        System.out.println("结束进入同步块，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
    }
}
