package chapter1;

/**
 * @Author xusf
 * @Date 2020/1/6 10:45
 * @Description : 测试Yield方法
 */
public class TestYieldThread extends Thread {
    @Override
    public void run() {
        super.run();
//        开始时间
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
//            打开注释打印了总共运行了16秒，不打开注释打印了总共运行了0秒
//            Thread.yield();
        }
//        结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("总共运行了" + (endTime - beginTime) + "秒");
    }
}
