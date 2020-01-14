package chapter4;
/**
* @Author xusf
* @Date 2020/1/14 14:06
* @Description : lock实现的多个生产者和消费者
*/
public class TestLockThread10 extends Thread{
    private TestLock5 testLock5;

    public TestLockThread10(TestLock5 testLock5) {
        this.testLock5 = testLock5;
    }

    @Override
    public void run() {
        super.run();
        testLock5.consume();
    }
}
