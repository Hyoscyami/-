package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:41
* @Description : 测试同步不具有继承性，即父类方法加了synchronized，子类重写该方法时不加synchronized，多线程执行子类方法时不会同步
*/
public class TestSynchronized12 {
    public synchronized void service() {
        System.out.println("这里是父类TestSynchronized12的service方法，当前线程名:" + Thread.currentThread().getName() + ",时间戳:" + System.currentTimeMillis());
    }
}
