package chapter1;
/**
* @Author xusf
* @Date 2020/1/6 11:34
* @Description : 测试优先级继承特性
*/
public class TestPriorityThread2 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("TestPriorityThread2的优先级:" + this.getPriority());
    }
}
