package chapter3;
/**
* @Author xusf
* @Date 2020/1/13 17:18
* @Description : 测试不同线程在ThreadLocal中的值不同
*/
public class TestThreadLocal3 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("开始执行TestThreadLocal3的run方法");
        TestThreadLocal.THREAD_LOCAL.set("TestThreadLocal3");
        System.out.println("TestThreadLocal3的值:" + TestThreadLocal.THREAD_LOCAL.get());
    }
}
