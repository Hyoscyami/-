package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:23
* @Description : 测试出现异常会自动释放锁
*/
public class TestSynchronized11 extends Thread{
    private TestSynchronized10 testSynchronized10;
    private long sleepTime;
    public TestSynchronized11(){

    }
    public TestSynchronized11(TestSynchronized10 testSynchronized10,long sleepTime,String threadName){
        this.testSynchronized10 = testSynchronized10;
        this.sleepTime = sleepTime;
        setName(threadName);
    }
    @Override
    public void run() {
        super.run();
        testSynchronized10.testMethod(sleepTime);
    }
}
