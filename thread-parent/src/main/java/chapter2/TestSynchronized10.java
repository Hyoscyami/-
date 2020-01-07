package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:23
* @Description : 测试出现异常会自动释放锁
*/
public class TestSynchronized10 {
    public synchronized void testMethod(long sleepTime){
        try {
            System.out.println("线程:" + Thread.currentThread().getName() + "开始进入testMethod方法，时间戳:" + System.currentTimeMillis());
            Thread.sleep(sleepTime);
            System.out.println("线程:" + Thread.currentThread().getName() + "睡醒啦，马上要抛异常啦！时间戳:" + System.currentTimeMillis());
            Integer.parseInt("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
