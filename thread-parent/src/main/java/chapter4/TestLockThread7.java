package chapter4;
/**
* @Author xusf
* @Date 2020/1/14 10:18
* @Description : 测试一个lock和多个condition
*/
public class TestLockThread7 extends Thread {
    private TestLock3 testLock3;

    public TestLockThread7(TestLock3 testLock3) {
        this.testLock3 = testLock3;
    }

    @Override
    public void run() {
        super.run();
        testLock3.awaitB();
    }
}
