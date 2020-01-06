package chapter2;

import org.junit.Test;

/**
 * @Author xusf
 * @Date 2020/1/6 15:45
 * @Description :  Synchronized关键字相关测试
 */
public class SynchronizedTest {
    /**
     * 测试成员变量线程安全性
     * 这里本来应该打印：
     * 进入了a部分
     * username:a的i=100
     * 进入了b部分
     * username:b的i=200
     * 但是成员变量被多个线程访问，没有同步导致打印出来了
     * 进入了a部分
     * 进入了b部分
     * username:b的i=200
     * username:a的i=200
     * */
    @Test
    public void testMemberSafe() {
        TestSynchronized testSynchronized = new TestSynchronized();
        TestSynchronized2 testSynchronized2 = new TestSynchronized2(testSynchronized,"a");
        TestSynchronized2 testSynchronized3 = new TestSynchronized2(testSynchronized,"b");
        testSynchronized2.start();
        testSynchronized3.start();
        try {
//            睡两秒保证能打印出来
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试对不同对象加锁是否可以同步
     * 其实是不会同步的，是异步，因为这里的加锁是加在成员函数上的，不是静态方法上，所以锁加在对象上
     */
    @Test
    public void testSynchronized(){
        TestSynchronized testSynchronized = new TestSynchronized();
        TestSynchronized testSynchronized1 = new TestSynchronized();
        TestSynchronized2 testSynchronized2 = new TestSynchronized2(testSynchronized,"a");
        TestSynchronized2 testSynchronized3 = new TestSynchronized2(testSynchronized1,"b");
        testSynchronized2.start();
        testSynchronized3.start();
        try {
//            这里不睡的话测试方法先执行完了就不会打印了
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
