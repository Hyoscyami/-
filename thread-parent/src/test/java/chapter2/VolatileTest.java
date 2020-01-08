package chapter2;

import org.junit.Test;

/**
 * @Author xusf
 * @Date 2020/1/8 10:31
 * @Description : volatile关键字测试，我感觉这个关键字只要理解内存模型，关联起虚拟机的相关知识就行了，不推荐使用这个关键字，synchronized关键字优化挺好的
 */
public class VolatileTest {
    /**
     * 测试没加volatile，导致main线程一直在执行while循环
     */
    @Test
    public void testVolatile() {
        TestVolatile testVolatile = new TestVolatile();
        testVolatile.print();
//        这里就算设置false也停止不了打印，因为main线程一直在打印循环里，走不到这一步
        testVolatile.setFlag(false);
    }

    /**
     * 测试使用多线程的方式修改死循环条件，跳出死循环，但是这种方式在-server服务器模式中64bit的JVM上，会出现死循环
     * 解决办法就是将TestVolatile2的flag成员变量加上volatile
     */
    @Test
    public void testVolatile2() {
        TestVolatile2 testVolatile2 = new TestVolatile2();
        Thread thread = new Thread(testVolatile2);
        thread.start();
//        这里就算设置false也停止不了打印，因为main线程一直在打印循环里，走不到这一步
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testVolatile2.setFlag(false);
    }
}
