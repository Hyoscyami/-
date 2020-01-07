package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:44
* @Description : 测试同步不具有继承性，即父类方法加了synchronized，子类重写该方法时不加synchronized，多线程执行子类方法时不会同步
*/
public class TestSynchronized14 extends Thread {
    private TestSynchronized13 testSynchronized13;

    public TestSynchronized14(TestSynchronized13 testSynchronized13) {
        this.testSynchronized13 = testSynchronized13;
    }

    @Override
    public void run() {
        super.run();
        testSynchronized13.service();
    }
}
