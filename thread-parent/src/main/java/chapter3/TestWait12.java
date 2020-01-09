package chapter3;

import java.util.List;
/**
* @Author xusf
* @Date 2020/1/9 15:25
* @Description : 测试单个生产者和消费者模式(其实这个示范有点跑偏了，虽然结果和生产者消费者模式一致，但是生产者和消费者并没有直接通过wait和notify通信，而是通过了共同的list)
*/
public class TestWait12 {
    private List<String> list;

    public TestWait12(List<String> list) {
        this.list = list;
    }

    public void consume(List<String> list) {
        synchronized (list) {
            System.out.println("进入consume方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
            if (list.size() == 0) {
                try {
                    System.out.println("开始等待生产者生产，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
                    list.wait();
                    System.out.println("收到生产者发起的通知，当前线程名：" + Thread.currentThread().getName() + "时间戳：" +System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("开始消费，吃掉list第0个元素，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            list.remove(0);
            System.out.println("吃完了第0个元素，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        }
    }
}
