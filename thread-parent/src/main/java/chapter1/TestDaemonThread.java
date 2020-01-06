package chapter1;
/**
* @Author xusf
* @Date 2020/1/6 13:55
* @Description : 测试守护线程特性
*/
public class TestDaemonThread extends Thread{
    @Override
    public void run() {
        super.run();
        int i = 0;
        while (true){
            i++;
            System.out.println("i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
