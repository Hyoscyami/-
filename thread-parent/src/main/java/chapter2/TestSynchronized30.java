package chapter2;
/**
* @Author xusf
* @Date 2020/1/8 9:29
* @Description : 模拟死锁
*/
public class TestSynchronized30 extends Thread{
    private TestSynchronized28 testSynchronized28;

    public TestSynchronized30(TestSynchronized28 testSynchronized28) {
        this.testSynchronized28 = testSynchronized28;
    }

    @Override
    public void run() {
        super.run();
        testSynchronized28.method2();
    }
}
