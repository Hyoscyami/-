package chapter2;

public class TestSynchronized5 {
    /**
     * 因为synchronized有可重入特性，所以这里才不会死锁，同一个对象可以再次获得自己的内部锁
     */
    public synchronized void service() {
        System.out.println("模拟执行service方法");
        service2();
    }

    public synchronized void service2() {
        System.out.println("模拟执行service2方法");
        service3();
    }

    public synchronized void service3() {
        System.out.println("模拟执行service3方法");
    }
}
