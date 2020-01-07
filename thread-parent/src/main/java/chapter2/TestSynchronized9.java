package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:16
* @Description : 用来测试synchronized关键字可重入特性也支持父子继承
*/
public class TestSynchronized9 extends Thread {
    @Override
    public void run() {
        super.run();
        TestSynchronized8 testSynchronized8 = new TestSynchronized8();
        testSynchronized8.subMethod2();
    }
}
