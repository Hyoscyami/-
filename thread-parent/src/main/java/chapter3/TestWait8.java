package chapter3;

import java.util.List;
/**
* @Author xusf
* @Date 2020/1/9 14:10
* @Description : 测试多个线程进入wait以后都被唤醒，重复执行代码，例如多个线程都删除list导致数组越界
*/
public class TestWait8 {
    private String lock;
    private List<String> list;

    public TestWait8(String lock,List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    public void add() {
        synchronized (lock) {
            list.add("something");
            lock.notifyAll();
        }
    }
}
