package chapter3;

/**
 * @Author xusf
 * @Date 2020/1/13 14:10
 * @Description : 测试join基本使用方式
 */
public class TestJoin extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("开始执行TestJoin的run方法");
            Thread.sleep(1000);
            System.out.println("执行TestJoin的run方法完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
