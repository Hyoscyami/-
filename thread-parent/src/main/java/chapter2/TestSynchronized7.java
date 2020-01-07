package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:16
* @Description : 用来测试synchronized关键字可重入特性也支持父子继承
*/
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
