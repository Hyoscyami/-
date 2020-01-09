package chapter3;

import java.util.List;

public class TestProduct {
    private Object lock;
    private List<String> list;

    public TestProduct(Object lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    public void product() {
        synchronized (lock) {
            System.out.println("开始进入生产者，当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            if (list.size() > 0) {
                try {
                    System.out.println("list里面的小饼干还没吃完了，生产者开始等待小饼干吃完。当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("收到了消费者吃掉小饼干的通知啦，准备开始生产一个小饼干,当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            list.add("小饼干" + System.currentTimeMillis());
            System.out.println("生产者做完了一个了小饼干，开始通知消费者继续吃小饼干！当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            lock.notify();
            System.out.println("发送通知完成，等待生产者继续做小饼干！当前线程名:" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
        }
    }
}
