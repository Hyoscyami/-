package chapter4;
/**
* @Author xusf
* @Date 2020/1/14 9:34
* @Description : lock基本用法
*/
public class TestLockThread2 extends Thread {
    private TestLock testLock;

    public TestLockThread2(TestLock testLock) {
        this.testLock = testLock;
    }

    @Override
    public void run() {
        super.run();
        testLock.method();
    }
}
