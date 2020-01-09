package chapter3;
/**
* @Author xusf
* @Date 2020/1/9 14:39
* @Description : 测试多个线程进入wait以后都被唤醒，重复执行代码，例如多个线程都删除list导致数组越界
*/
public class TestWait11 extends Thread{
    private TestWait9 testWait9;
    public TestWait11(TestWait9 testWait9){
        this.testWait9 = testWait9;
    }

    @Override
    public void run() {
        super.run();
        testWait9.sub();
    }
}
