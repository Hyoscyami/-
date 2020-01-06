package chapter1;
/**
* @Author xusf
* @Date 2020/1/6 9:48
* @Description : 测试沉睡中的线程被中断
*/
public class TestInterruptThread2 extends Thread{

    @Override
    public void run() {
        super.run();
        try{
            System.out.println("开始进入run方法，沉睡两秒，时间戳：" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("睡醒了，时间戳:" + System.currentTimeMillis());
        }catch (InterruptedException e){
            System.out.println("正在sleep的时候被中断，被catch啦!，中断状态：" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
