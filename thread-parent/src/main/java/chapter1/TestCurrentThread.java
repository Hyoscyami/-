package chapter1;

/**
 * @Author xusf
 * @Date 2020/1/3 15:34
 * @Description : 用来测试 CurrentThread和this的区别
 */
public class TestCurrentThread extends Thread {
    public TestCurrentThread() {
        System.out.println("TestCurrentThread---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
        System.out.println("this.getName=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("TestCurrentThread---end ");
        System.out.println("Thread.currentThread()==this :" + (Thread.currentThread() == this));
    }

    public TestCurrentThread(String threadName) {
        this.setName(threadName);
        System.out.println("---TestCurrentThread构造方法开始---");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
        System.out.println("this.getName=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("---TestCurrentThread构造方法结束---");
        System.out.println("Thread.currentThread()==this :" + (Thread.currentThread() == this));
    }

    @Override
    public void run() {
        System.out.println("---TestCurrentThread的run方法开始---");
        System.out.println("Thread.currentThread().getName=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()" + Thread.currentThread().isAlive());
        System.out.println("Thread.currentThread()==this :" + (Thread.currentThread() == this));
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("---TestCurrentThread的run方法结束---");
    }
}
