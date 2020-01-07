package chapter2;

public class TestSynchronized27 extends Thread {
    private TestSynchronized25 testSynchronized25;

    public TestSynchronized27(TestSynchronized25 testSynchronized25) {
        this.testSynchronized25 = testSynchronized25;
    }

    @Override
    public void run() {
        super.run();
        testSynchronized25.method2();
    }
}
