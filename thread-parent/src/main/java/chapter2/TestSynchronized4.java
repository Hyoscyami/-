package chapter2;

public class TestSynchronized4 extends Thread {
    private TestSynchronized3 testSynchronized3;

    public TestSynchronized4(TestSynchronized3 testSynchronized3) {
        this.testSynchronized3 = testSynchronized3;
    }

    @Override
    public void run() {
        super.run();
        testSynchronized3.setValue("b","bb");
    }
}
