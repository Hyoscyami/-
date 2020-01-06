package chapter1;

/**
 * @Author xusf
 * @Date 2020/1/4 16:19
 * @Description : 测试中断
 */
public class TestInterruptThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
