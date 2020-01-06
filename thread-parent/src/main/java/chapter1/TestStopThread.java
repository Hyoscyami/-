package chapter1;

/**
 * @Author xusf
 * @Date 2020/1/6 9:27
 * @Description : 测试停止线程
 */
public class TestStopThread extends Thread {
    @Override
    public void run() {
        super.run();
//        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("收到中断信号，开始停止执行run方法");
//                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
//        } catch (InterruptedException e) {
//            System.out.println("成功中断啦，这时候一般会执行线程收尾工作");
//            e.printStackTrace();
//        }
    }
}
