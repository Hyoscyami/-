package chapter1;

/**
 * @Author xusf
 * @Date 2020/1/6 11:10
 * @Description : 测试优先级继承特性
 */
public class TestPriorityThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("TestPriorityThread的优先级" + this.getPriority());
        TestPriorityThread2 testPriorityThread2 = new TestPriorityThread2();
        testPriorityThread2.start();
    }
}
