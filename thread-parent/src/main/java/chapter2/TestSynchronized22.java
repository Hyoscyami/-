package chapter2;

public class TestSynchronized22 extends Thread {
    private TestSynchronized20 testSynchronized20;

    public TestSynchronized22(TestSynchronized20 testSynchronized20) {
        this.testSynchronized20 = testSynchronized20;
    }

    @Override
    public void run() {
        super.run();
        TestSynchronized21 testSynchronized21 = new TestSynchronized21();
        testSynchronized21.addMethod(testSynchronized20,"a");
    }
}
