package chapter2;
/**
 * @Author xusf
 * @Date 2020/1/8 9:21
 * @Description : 测试同步代码块放到非同步代码块中进行声明，并不能保证调用方法的线程的循序性，也就是线程调用非同步代码是无序的情况下导致脏读
 */
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
