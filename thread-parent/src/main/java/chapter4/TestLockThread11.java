package chapter4;
/**
* @Author xusf
* @Date 2020/1/14 14:07
* @Description : lock实现的多个生产者和消费者
*/
public class TestLockThread11 extends Thread{
    private TestLock5 testLock5;

    public TestLockThread11(TestLock5 testLock5) {
        this.testLock5 = testLock5;
    }

    @Override
    public void run() {
        super.run();
        testLock5.product();
    }
}
