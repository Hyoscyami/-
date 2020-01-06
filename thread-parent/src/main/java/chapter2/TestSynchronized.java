package chapter2;

/**
 * @Author xusf
 * @Date 2020/1/6 14:28
 * @Description : 测试成员变量线程安全
 */
public class TestSynchronized {
    private int i = 0;

    /**
     * 这个方法不同步的话，多个线程会并发修改成员变量导致线程不安全
     * @param username
     */
    public synchronized void add(String username) {
        if ("a".equals(username)) {
            System.out.println("进入了a部分");
            i = 100;
            try {
//                模拟执行任务耗时，不然时间太短了不容易显示线程不安全造成的后果
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("进入了b部分");
            i = 200;
        }
        System.out.println("username:" + username + "的i=" + i);
    }
}
