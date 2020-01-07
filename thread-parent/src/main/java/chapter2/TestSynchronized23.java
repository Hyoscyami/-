package chapter2;

public class TestSynchronized23 {
    public void method(String name){
//        不要这么写，这里这么写是因为测试常量池特性对同步的影响。其实也没什么，说到底还是看是否锁的是同一个对象
        synchronized (name){
            System.out.println("开始执行method方法，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束执行method方法，当前线程名:" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        }
    }
}
