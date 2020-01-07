package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:15
* @Description : 用来测试只同步set方法不同步get方法导致的脏读问题
*/
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
