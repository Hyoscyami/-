package chapter2;

public class TestSynchronized25 {
    Object object = new Object();
    Object object1 = new Object();
    /**
     * 这种情况会导致其他同步方法都无法被其他线程执行
     * 解决方法如下：这样子的话每个方法都有对应的成员变量可以加锁，不会都影响到其他同步方法，不过要是都这么写的话那不是新增一个方法就要新增一个成员变量给他锁，有没有其他好办法？
     * 不过这种解决方案不适合同步方法之间有顺序依赖的，毕竟锁的不是同一个对象，他是异步执行的，可能会按照非预期的情况去无序执行
     * public void method() {
     *      synchronized（object){
     *      System.out.println("开始执行method方法，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
     *               while (true) {
     *
     *               }
     *      }
     *     }
     */
    public synchronized void method() {
        System.out.println("开始执行method方法，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        while (true) {

        }
    }

    /**
     * 解决方法如下：
     * public void method2() {
     *      synchronized(object1){
     *         System.out.println("开始执行method2方法，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
     *      }
     *     }
     */
    public synchronized void method2() {
        System.out.println("开始执行method2方法，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
    }
}
