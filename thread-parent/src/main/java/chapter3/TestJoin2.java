package chapter3;

/**
 * @Author xusf
 * @Date 2020/1/13 14:56
 * @Description : 测试join不在run方法用，在test方法里面对TestJoin2对象直接调用join方法
 */
public class TestJoin2 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("开始执行TestJoin2的run方法");
            Thread.sleep(1000);
            System.out.println("执行TestJoin2的run方法完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
