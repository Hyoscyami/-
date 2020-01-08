package chapter3;
/**
* @Author xusf
* @Date 2020/1/8 14:19
* @Description : 测试wait和notify
*/
public class TestWait {
    public void method() {
        System.out.println("开始进入TestWait的method方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("TestWait的method方法catch了中断异常");
                e.printStackTrace();
            }
        }
        System.out.println("结束TestWait的method方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
    }

    public void method2() {
        System.out.println("开始进入TestWait的method方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
        synchronized (this) {
            try {
                this.wait(1000);
            } catch (InterruptedException e) {
                System.out.println("TestWait的method方法catch了中断异常");
                e.printStackTrace();
            }
        }
        System.out.println("结束TestWait的method方法，当前线程名：" + Thread.currentThread().getName() + "时间戳：" + System.currentTimeMillis());
    }
}
