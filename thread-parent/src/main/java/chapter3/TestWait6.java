package chapter3;

/**
 * @Author xusf
 * @Date 2020/1/9 9:58
 * @Description : 解决notify先通知然后线程再进入wait导致长时间wait
 */
public class TestWait6 extends Thread {
    private TestWait5 testWait5;

    public TestWait6(TestWait5 testWait5) {
        this.testWait5 = testWait5;
    }

    @Override
    public void run() {
        super.run();
        testWait5.method();
    }
}
