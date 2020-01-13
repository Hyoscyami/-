package chapter3;
/**
* @Author xusf
* @Date 2020/1/13 15:33
* @Description : 测试当join遇到中断
*/
public class TestJoin4 extends Thread {
    private TestJoin3 testJoin3;

    public TestJoin4(TestJoin3 testJoin3) {
        this.testJoin3 = testJoin3;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("开始执行TestJoin4的run方法，将要中断testJoin3");
        testJoin3.interrupt();
        System.out.println("执行TestJoin4的run方法完毕，已经发送中断testJoin3信号");
    }
}
