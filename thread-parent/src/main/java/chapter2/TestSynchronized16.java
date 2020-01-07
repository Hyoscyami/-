package chapter2;

/**
 * @Author xusf
 * @Date 2020/1/7 10:20
 * @Description : 测试同步代码块，即当方法中有阻塞时间过长的内容直接同步方法会使并发急剧下降，此时可以同步会出现线程不安全的代码块，提升并发量
 */
public class TestSynchronized16 extends Thread {
    private TestSynchronized15 testSynchronized15;
    private String username;
    private String password;

    public TestSynchronized16(TestSynchronized15 testSynchronized15, String username, String password) {
        this.testSynchronized15 = testSynchronized15;
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        super.run();
        long startTime = System.currentTimeMillis();
        System.out.println("线程:" + Thread.currentThread().getName() + "开始执行run方法，时间戳:" + startTime);
        testSynchronized15.setValue2(username, password);
        long endTime = System.currentTimeMillis();
        System.out.println("线程:" + Thread.currentThread().getName() + "结束执行run方法，时间戳:" + endTime + "总耗时:" + (endTime - startTime));
    }
}
