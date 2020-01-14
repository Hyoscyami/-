package chapter4;
/**
* @Author xusf
* @Date 2020/1/14 10:47
* @Description : lock实现单个消费者和生产者
*/
public class TestLockThread9 extends Thread {
    private TestLock4 testLock4;

    public TestLockThread9(TestLock4 testLock4) {
        this.testLock4 = testLock4;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 2; i++) {
            testLock4.product();
        }
    }
}
