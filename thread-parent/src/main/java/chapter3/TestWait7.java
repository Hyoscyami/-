package chapter3;
/**
* @Author xusf
* @Date 2020/1/9 10:01
* @Description : 解决notify先通知然后线程再进入wait导致长时间wait
*/
public class TestWait7 extends Thread{
    private final TestWait5 testWait5;

    public TestWait7(TestWait5 testWait5){
        this.testWait5 = testWait5;
    }

    /**
     * 其实这样子测试还是有点问题，不适合一定要执行包含wait方法的场景，不然的话先notify执行了以后，wait方法就一直不会执行了
     */
    @Override
    public void run() {
        super.run();
        synchronized (testWait5){
            System.out.println("开始通知线程啦，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
            testWait5.notify();
            System.out.println("结束通知线程啦，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
            testWait5.setFlag(true);
        }
    }
}
