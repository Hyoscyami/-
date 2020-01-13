package chapter3;
/**
* @Author xusf
* @Date 2020/1/13 17:27
* @Description : 初始化ThreadLocal没set的时候调用get方法获取到的值
*/
public class TestThreadLocal5 extends Thread{
    private TestThreadLocal4 testThreadLocal4 = new TestThreadLocal4();
    @Override
    public void run() {
        super.run();
        System.out.println("开始执行TestThreadLocal5的run方法");
        System.out.println("重写过的ThreadLocal初始化方法，现在还没赋值过，get到的值:" + testThreadLocal4.get());
    }
}
