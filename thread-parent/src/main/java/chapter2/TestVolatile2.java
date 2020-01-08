package chapter2;
/**
* @Author xusf
* @Date 2020/1/8 10:34
* @Description : 使用线程的方式执行死循环方法，然后更改条件调出死循环
*/
public class TestVolatile2 implements Runnable {
    private volatile boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void print() {
        while (flag) {
            System.out.println("正在执行print，当前线程:" + Thread.currentThread().getName());
        }
        System.out.println("flag是false啦！");
    }
    @Override
    public void run() {
        print();
    }
}
