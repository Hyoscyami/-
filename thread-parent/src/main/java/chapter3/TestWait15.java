package chapter3;

import java.util.List;
/**
* @Author xusf
* @Date 2020/1/9 15:25
* @Description : 测试单个生产者和消费者模式
*/
public class TestWait15 extends Thread {
    private TestWait13 testWait13;
    private List<String> list;

    public TestWait15(TestWait13 testWait13, List<String> list) {
        this.testWait13 = testWait13;
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1; i++) {
            testWait13.product();
        }
    }
}
