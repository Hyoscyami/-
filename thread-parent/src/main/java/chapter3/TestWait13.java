package chapter3;

import java.util.List;
/**
* @Author xusf
* @Date 2020/1/9 15:25
* @Description : 测试单个生产者和消费者模式(其实这个示范有点跑偏了，虽然结果和生产者消费者模式一致，但是生产者和消费者并没有直接通过wait和notify通信，而是通过了共同的list)
*/
public class TestWait13 {
    private List<String> list;

    public TestWait13(List<String> list) {
        this.list = list;
    }

    public void product() {
        synchronized (list) {
            System.out.println("开始进入product方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
            if (list.size() == 0) {
                System.out.println("消费者吃完了，开始生产，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
                list.add("小饼干" + System.currentTimeMillis());
                list.notifyAll();
                System.out.println("生产完了，也通知完了，等消费者消费啦");
            }
            System.out.println("product方法结束，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        }
    }
}
