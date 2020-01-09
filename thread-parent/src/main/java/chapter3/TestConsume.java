package chapter3;

import java.util.List;

public class TestConsume {
    private Object lock;
    private List<String> list;

    public TestConsume(Object lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    public void consume() {
        synchronized (lock) {
            System.out.println("开始进入消费者，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            if (list.size() == 0){
                try {
                    System.out.println("list里面的小饼干吃完了，消费者开始等待生产小饼干。当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("收到了生产者做好小饼干的通知啦，准备开始吃一个小饼干,当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            list.remove(0);
            System.out.println("消费者吃完了小饼干，开始通知生产者继续做小饼干！当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            lock.notify();
            System.out.println("发送通知完成，等待生产者继续做小饼干！当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        }
    }
}
