package chapter3;

/**
 * @Author xusf
 * @Date 2020/1/9 9:55
 * @Description : 解决notify先通知然后线程再进入wait导致长时间wait
 */
public class TestWait5 {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void method() {
        synchronized (this){
            while (!flag) {
                System.out.println("开始执行wait，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println("收到中断信号");
                    e.printStackTrace();
                }
                System.out.println("结束执行wait，当前线程名：" + Thread.currentThread().getName() + "时间戳:" + System.currentTimeMillis());
            }
        }
    }
}
