package chapter3;
/**
* @Author xusf
* @Date 2020/1/13 17:15
* @Description : 测试不同线程在ThreadLocal中的值不同
*/
public class TestThreadLocal2 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("开始执行TestThreadLocal2的run方法");
        TestThreadLocal.THREAD_LOCAL.set("TestThreadLocal2");
        System.out.println("TestThreadLocal2的值:" + TestThreadLocal.THREAD_LOCAL.get());
    }
}
