package chapter3;

import java.util.List;
/**
* @Author xusf
* @Date 2020/1/9 15:25
* @Description : 测试单个生产者和消费者模式(其实这个示范有点跑偏了，虽然结果和生产者消费者模式一致，但是生产者和消费者并没有直接通过wait和notify通信，而是通过了共同的list)
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
