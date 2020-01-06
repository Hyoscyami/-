package chapter2;

public class TestSynchronized6 extends Thread{
    @Override
    public void run() {
        super.run();
        TestSynchronized5 testSynchronized5 = new TestSynchronized5();
        testSynchronized5.service();
    }
}
