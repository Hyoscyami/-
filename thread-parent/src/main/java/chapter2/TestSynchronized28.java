package chapter2;
/**
* @Author xusf
* @Date 2020/1/8 9:28
* @Description : 模拟死锁
*/
public class TestSynchronized28 {
    final Object lock = new Object();
    final Object lock2 = new Object();

    /**
     * 前面有讲过，所有方法都加synchronized，效率太低了，但是这种情况，会有死锁的
     */
    public void method(){
        System.out.println("开始进入method方法，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        synchronized (lock){
            System.out.println("开始进入method方法同步代码块，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        }
        try {
//            模拟执行任务耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock2){
            this.method2();
        }
        System.out.println("顺利按照method->到method2执行");
    }

    public void method2(){
        System.out.println("开始进入method2方法，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        synchronized (lock2){
            System.out.println("开始进入method2方法同步代码块，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        }
        try {
//            模拟执行任务耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            this.method();
        }
        System.out.println("顺利按照method2->到method执行");
    }
}
