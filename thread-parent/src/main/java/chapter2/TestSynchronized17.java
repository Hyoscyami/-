package chapter2;

/**
 * @Author xusf
 * @Date 2020/1/7 13:52
 * @Description : 测试synchronized代码块之间的同步性，即同一个对象的锁被占用，另一个线程不能访问所有被加锁的方法
 */
public class TestSynchronized17 {

    public synchronized void method() {
        System.out.println("这是TestSynchronized17的method方法，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是TestSynchronized17的method方法末尾，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
    }

    public synchronized void method2() {
        System.out.println("这是TestSynchronized17的method2方法，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是TestSynchronized17的method2方法末尾，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
    }
}
