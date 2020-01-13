package chapter3;

import org.junit.Test;

/**
 * @Author xusf
 * @Date 2020/1/13 17:20
 * @Description : 测试ThreadLocal
 */
public class ThreadLocalTest {
    /**
     * 测试不同的线程分别赋值给ThreadLocal以及从ThreadLocal中取值是否对应
     */
    @Test
    public void test() {
        TestThreadLocal2 testThreadLocal2 = new TestThreadLocal2();
        TestThreadLocal3 testThreadLocal3 = new TestThreadLocal3();
        testThreadLocal2.start();
        testThreadLocal3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重写ThreadLocal的初始化方法测试
     */
    @Test
    public void test2() {
        TestThreadLocal5 testThreadLocal5 = new TestThreadLocal5();
        testThreadLocal5.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
