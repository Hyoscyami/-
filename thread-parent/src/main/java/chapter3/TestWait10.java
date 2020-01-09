package chapter3;
/**
* @Author xusf
* @Date 2020/1/9 14:39
* @Description : 测试多个线程进入wait以后都被唤醒，重复执行代码，例如多个线程都删除list导致数组越界
*/
public class TestWait10 extends Thread {
    private TestWait8 testWait8;

    public TestWait10(TestWait8 testWait8) {
        this.testWait8 = testWait8;
    }

    @Override
    public void run() {
        super.run();
        testWait8.add();
    }
}
