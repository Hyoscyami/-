package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:16
* @Description : 用来测试synchronized关键字可重入特性也支持父子继承
*/
public class TestSynchronized8 extends TestSynchronized7{
    public synchronized void subMethod2(){
        while (i > 0){
            i--;
            System.out.println("TestSynchronized8方法执行，i=" + i);
            try {
                Thread.sleep(100);
                this.subMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
