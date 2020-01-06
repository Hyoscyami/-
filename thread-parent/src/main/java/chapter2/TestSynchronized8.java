package chapter2;

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
