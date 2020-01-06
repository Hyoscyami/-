package chapter2;

public class TestSynchronized9 extends Thread {
    @Override
    public void run() {
        super.run();
        TestSynchronized8 testSynchronized8 = new TestSynchronized8();
        testSynchronized8.subMethod2();
    }
}
