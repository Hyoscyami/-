package chapter3;

import java.util.List;
/**
* @Author xusf
* @Date 2020/1/9 14:39
* @Description : 测试多个线程进入wait以后都被唤醒，重复执行代码，例如多个线程都删除list导致数组越界
*/
public class TestWait9 {
    private String lock;
    private List<String> list;

    public TestWait9(String lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    public void sub() {
        synchronized (lock) {
//            这里if改成while就不会数组越界异常了，但是我认为这不是一个好办法，可以在remove那里再判断一下list的size是否大于0就好了
//            由于测试方法锁的是同一个string，也就是同一个对象，判断size是否大于0的时候可以不用同步防止脏读了
            if (list.size() == 0) {
                System.out.println("开始进入sub()方法，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sub()方法wait结束，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            }
            list.remove(0);
            System.out.println("remove结束，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        }
    }
}
