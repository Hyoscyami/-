package chapter4;
/**
* @Author xusf
* @Date 2020/1/14 10:16
* @Description : 测试一个lock和多个condition
*/
public class TestLockThread4 extends Thread {
    private TestLock3 testLock3;

    public TestLockThread4(TestLock3 testLock3) {
        this.testLock3 = testLock3;
    }

    @Override
    public void run() {
        super.run();
        testLock3.awaitA();
    }
}
