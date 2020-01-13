package chapter3;

import java.util.List;
/**
* @Author xusf
* @Date 2020/1/9 15:25
* @Description : 测试单个生产者和消费者模式
*/
public class TestWait14 extends Thread {
    /**
     * 消费者
     */
    private TestWait12 testWait12;
    private List<String> list;

    public TestWait14(TestWait12 testWait12, List<String> list) {
        this.testWait12 = testWait12;
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1; i++) {
            testWait12.consume(list);
        }
    }
}
