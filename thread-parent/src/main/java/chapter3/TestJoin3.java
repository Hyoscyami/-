package chapter3;

/**
 * @Author xusf
 * @Date 2020/1/13 15:30
 * @Description : 测试当join遇到中断
 */
public class TestJoin3 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("开始执行TestJoin3的run方法");
        TestJoin testJoin = new TestJoin();
        try {
            testJoin.start();
            testJoin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行TestJoin3的run方法完毕");
    }
}
