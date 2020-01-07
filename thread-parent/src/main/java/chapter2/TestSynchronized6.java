package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:15
* @Description : 用来测试synchronized关键字可重入特性
*/
public class TestSynchronized6 extends Thread{
    @Override
    public void run() {
        super.run();
        TestSynchronized5 testSynchronized5 = new TestSynchronized5();
        testSynchronized5.service();
    }
}
