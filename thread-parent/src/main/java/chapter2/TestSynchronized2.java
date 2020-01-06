package chapter2;

/**
 * @Author xusf
 * @Date 2020/1/6 15:46
 * @Description : 测试不同线程同时访问成员变量
 */
public class TestSynchronized2 extends Thread {
    private TestSynchronized testSynchronized;
    private String username;

    public TestSynchronized2(TestSynchronized testSynchronized, String username) {
        this.testSynchronized = testSynchronized;
        this.username = username;
    }

    @Override
    public void run() {
        super.run();
        testSynchronized.add(username);
    }
}
