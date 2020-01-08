package chapter2;
/**
* @Author xusf
* @Date 2020/1/8 10:30
* @Description : 没加volatile关键字时，main线程一直在跑print的while循环，导致test方法一直执行
*/
public class TestVolatile {
    private boolean flag = true;

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
    }
}
