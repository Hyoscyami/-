package chapter4;

public class TestLockThread extends Thread{
    private TestLock testLock;

    public TestLockThread(TestLock testLock) {
        this.testLock = testLock;
    }

    @Override
    public void run() {
        super.run();
        testLock.method();
    }
}
