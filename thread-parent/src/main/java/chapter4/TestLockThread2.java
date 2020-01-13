package chapter4;

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
