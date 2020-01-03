package chapter1;

import org.junit.Test;

/**
* @Author xusf
* @Date 2020/1/3 11:07
* @Description : 线程常用方法
*/
public class BaseMethod {
    /**
     * 获得当前线程
     */
    @Test
    public void testCurrentThread(){
        /**
         * 这里直接打印会打印出：Thread[main,5,main]，分别是当前线程名，当前线程优先级，当前线程组名
         * 具体可参考Thread的toString方法：
         * ThreadGroup group = getThreadGroup();
         *         if (group != null) {
         *             return "Thread[" + getName() + "," + getPriority() + "," +
         *                            group.getName() + "]";
         *         } else {
         *             return "Thread[" + getName() + "," + getPriority() + "," +
         *                             "" + "]";
         *         }
         */
        System.out.println(Thread.currentThread());
    }

    /**
     * 判断线程是否处于活动状态
     * 活动状态就是线程已经启动且尚未终止。线程处于正在运行或准备开始运行的状态。
     */
    @Test
    public void testIsAlive() throws InterruptedException {
        FirstThread firstThread = new FirstThread("firstThread");
        System.out.println("线程没有启动前的活动状态:" + firstThread.isAlive());
//        如果是用firstThread.run();代替firstThread.start();，会打印“启动线程后的活动状态：false”，因为只是运行了一个线程的方法
        firstThread.start();
//        不睡两秒的情况下，这时候firstThread还在运行状态或者准备运行状态，此时会打印出“启动线程后的活动状态：true”
//        睡了两秒后，线程已经执行完了，状态不是活动状态了，此时会打印出“启动线程后的活动状态：false”
//        Thread.sleep(2000);
        System.out.println("启动线程后的活动状态：" + firstThread.isAlive());
    }

    /**
     * 测试this.getName()为什么和Thread.currentThread().getName的不同
     */
    @Test
    public void testCurrentThreadAndThis() throws InterruptedException {
        TestCurrentThread myThread = new TestCurrentThread("测试线程");
        myThread.start();
        Thread thread = new Thread(myThread);
        System.out.println("main begin thread isAlive=" + thread.isAlive());
        thread.setName("测试");
        thread.start();
        Thread.sleep(1000);
        System.out.println("main end thread isAlive=" + thread.isAlive());
    }
}
