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
        System.out.println("---TestCurrentThread构造方法开始，这时候是main线程在运行构造方法---");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
        System.out.println("这时候this指向的是新建的TestCurrentThread对象，名字就是这个对象的名字。所以this.getName=" + this.getName());
        System.out.println("这时候新建的TestCurrentThread对象状态不是活动状态，所以this.isAlive()=" + this.isAlive());
        System.out.println("---到这里TestCurrentThread构造方法就结束了---");
        System.out.println("这时候Thread.currentThread()是main线程，this是新建的TestCurrentThread对象，所以Thread.currentThread()==this :" + (Thread.currentThread() == this));
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
