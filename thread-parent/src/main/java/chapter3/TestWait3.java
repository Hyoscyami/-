package chapter3;
/**
* @Author xusf
* @Date 2020/1/8 14:59
* @Description : 测试wait和notify
*/
public class TestWait3 extends Thread{
    private final TestWait testWait;

    public TestWait3(TestWait testWait) {
        this.testWait = testWait;
    }

    @Override
    public void run() {
        super.run();
        testWait.method();
    }
}
