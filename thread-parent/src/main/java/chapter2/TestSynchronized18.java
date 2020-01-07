package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 13:58
* @Description : 测试synchronized代码块之间的同步性，即同一个对象的锁被占用，另一个线程不能访问所有被加锁的方法
*/
public class TestSynchronized18 extends Thread{
    private TestSynchronized17 testSynchronized17;
    public TestSynchronized18(TestSynchronized17 testSynchronized17){
        this.testSynchronized17 = testSynchronized17;
    }

    @Override
    public void run() {
        super.run();
        testSynchronized17.method();
    }
}
