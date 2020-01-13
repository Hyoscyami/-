package chapter3;

import org.junit.Test;

/**
* @Author xusf
* @Date 2020/1/13 11:46
* @Description : 测试join
*/
public class JoinTest {
    /**
     * 测试join基本用法，join用的是wait实现，
     */
    @Test
    public void joinTest(){
        TestJoin testJoin = new TestJoin();
        testJoin.start();
        try {
            testJoin.join();
//            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我执行完了");
    }

    /**
     * 测试join用法，超过这个之间就会往下执行
     */
    @Test
    public void joinTest2(){
        TestJoin2 testJoin2 = new TestJoin2();
        testJoin2.start();
        try {
            System.out.println("开始join");
            testJoin2.join(10);
            System.out.println("join完了");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当join遇上中断，会抛中断异常
     */
    @Test
    public void joinTest3(){
        TestJoin3 testJoin3 = new TestJoin3();
        testJoin3.start();
        TestJoin4 testJoin4 = new TestJoin4(testJoin3);
        testJoin4.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
