package chapter2;

public class TestSynchronized7 {
    public int i= 10;
    public synchronized void subMethod(){
        i--;
        System.out.println("TestSynchronized7的subMethod正在执行，i=" + i);
        try {
//            模拟执行其他任务耗时
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
