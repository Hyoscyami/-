package chapter3;
/**
* @Author xusf
* @Date 2020/1/8 16:10
* @Description : 测试wait和notifyAll
*/
public class TestWait4 extends Thread{
    private final TestWait testWait;

    public TestWait4(TestWait testWait) {
        this.testWait = testWait;
    }

    @Override
    public void run() {
        super.run();
        synchronized (testWait){
            System.out.println("开始唤醒所有线程，当前线程名：" + Thread.currentThread().getName() + "当前时间戳:" + System.currentTimeMillis());
            testWait.notifyAll();
            System.out.println("结束唤醒所有线程，当前线程名：" + Thread.currentThread().getName() + "当前时间戳:" + System.currentTimeMillis());
        }
    }
}
