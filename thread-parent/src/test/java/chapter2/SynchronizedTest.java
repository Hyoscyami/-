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

    /**
     * 测试不加synchronized在get方法上导致脏读
     */
    @Test
    public void testSynchronized2(){
        TestSynchronized3 testSynchronized3 = new TestSynchronized3();
        TestSynchronized4 testSynchronized4 = new TestSynchronized4(testSynchronized3);
        testSynchronized4.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testSynchronized3.getValue();
    }

    /**
     * 测试synchronized的可重入特性
     */
    @Test
    public void testSynchronized3(){
        TestSynchronized6 testSynchronized6 = new TestSynchronized6();
        testSynchronized6.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试synchronized可重入特性在父子继承中也有效
     */
    @Test
    public void testSynchronized4(){
        TestSynchronized9 testSynchronized9 = new TestSynchronized9();
        testSynchronized9.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试出现异常会自动释放锁
     */
    @Test
    public void testSynchronized5(){
        TestSynchronized10 testSynchronized10 = new TestSynchronized10();
        TestSynchronized11 testSynchronized11 = new TestSynchronized11(testSynchronized10,200,"a");
        TestSynchronized11 testSynchronized111 = new TestSynchronized11(testSynchronized10,1000,"b");
        testSynchronized11.start();
        testSynchronized111.start();
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试同步不具有继承性
     */
    @Test
    public void testSynchronized6(){
        TestSynchronized13 testSynchronized13 = new TestSynchronized13();
        TestSynchronized14 testSynchronized14 = new TestSynchronized14(testSynchronized13);
        TestSynchronized14 testSynchronized141 = new TestSynchronized14(testSynchronized13);
        testSynchronized14.start();
        testSynchronized141.start();
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试synchronized同步代码块，方法耗时长的时候可以在保证线程安全的情况下只同步线程不安全的代码块
     */
    @Test
    public void testSynchronized7(){
        TestSynchronized15 testSynchronized15 = new TestSynchronized15();
        TestSynchronized16 testSynchronized16 = new TestSynchronized16(testSynchronized15,"a","aa");
        TestSynchronized16 testSynchronized161 = new TestSynchronized16(testSynchronized15,"b","bb");
        testSynchronized16.start();
        testSynchronized161.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试synchronized方法之间的同步性，即同一个对象的锁被占用，其他线程不能访问所有被加锁的方法
     * synchronized代码块和synchronized方法之间的同步性一样，就不再赘述
     */
    @Test
    public void testSynchronized8(){
        TestSynchronized17 testSynchronized17 = new TestSynchronized17();
        TestSynchronized18 testSynchronized18 = new TestSynchronized18(testSynchronized17);
//        TestSynchronized19 testSynchronized19 = new TestSynchronized19(testSynchronized17);
        testSynchronized18.start();
//        testSynchronized19.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一个现成乱序执行导致的现成不安全例子
     */
    @Test
    public void testSynchronized9(){
        TestSynchronized20 testSynchronized20 = new TestSynchronized20();
        TestSynchronized22 testSynchronized22 = new TestSynchronized22(testSynchronized20);
        TestSynchronized22 testSynchronized221 = new TestSynchronized22(testSynchronized20);
        testSynchronized22.start();
        testSynchronized221.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        这里本来期望应该是size=1,但是因为线程执行的不确定性导致脏读
        System.out.println("size:" + testSynchronized20.getSize());
    }

    /**
     * 测试常量池特性对synchronized的影响
     * 其实本质上和锁同一个对象一样的结果，总结来说就是锁的是同一个对象，那这个同步方法就是顺序执行
     */
    @Test
    public void testSynchronized10(){
        TestSynchronized23 testSynchronized23 = new TestSynchronized23();
        TestSynchronized24 testSynchronized24 = new TestSynchronized24(testSynchronized23,"a");
        TestSynchronized24 testSynchronized241 = new TestSynchronized24(testSynchronized23,"a");
//        如果使用的是这一行，那么打印出来的就是非同步的，因为锁的不是同一个对象
//        TestSynchronized24 testSynchronized241 = new TestSynchronized24(testSynchronized23,new String("a"));
        testSynchronized24.start();
        testSynchronized241.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试锁同一个对象后同步方法A长时间阻塞（极端情况如死循环），导致其他同步方法长时间无法执行
     */
    @Test
    public void testSynchronized11(){
        TestSynchronized25 testSynchronized25 = new TestSynchronized25();
        TestSynchronized26 testSynchronized26 = new TestSynchronized26(testSynchronized25);
        TestSynchronized27 testSynchronized27 = new TestSynchronized27(testSynchronized25);
        testSynchronized26.start();
        testSynchronized27.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
