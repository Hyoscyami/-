package chapter3;
/**
* @Author xusf
* @Date 2020/1/8 14:21
* @Description : 测试wait和notify
*/
public class TestWait2 extends Thread {
    private final TestWait testWait;

    public TestWait2(TestWait testWait) {
        this.testWait = testWait;
    }

    @Override
    public void run() {
        super.run();
        synchronized (testWait){
            System.out.println("开始唤醒线程，当前线程名：" + Thread.currentThread().getName() + "当前时间戳:" + System.currentTimeMillis());
            testWait.notify();
            System.out.println("结束唤醒线程，当前线程名：" + Thread.currentThread().getName() + "当前时间戳:" + System.currentTimeMillis());
        }
    }
}
