package chapter4;

public class TestLockThread3 extends Thread {
    private TestLock2 testLock2;

    public TestLockThread3(TestLock2 testLock2) {
        this.testLock2 = testLock2;
    }

    @Override
    public void run() {
        super.run();
        testLock2.await();
    }
}
