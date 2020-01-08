package chapter2;
/**
* @Author xusf
* @Date 2020/1/8 9:23
* @Description : 测试锁同一个对象后同步方法A长时间阻塞（极端情况如死循环），导致其他同步方法长时间无法执行
*/
public class TestSynchronized26 extends Thread{
    private TestSynchronized25 testSynchronized25;

    public TestSynchronized26(TestSynchronized25 testSynchronized25){
        this.testSynchronized25 = testSynchronized25;
    }

    @Override
    public void run() {
        super.run();
        testSynchronized25.method();
    }
}
