package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 9:15
* @Description : 用来测试只同步set方法不同步get方法导致的脏读问题
*/
public class TestSynchronized3 {
    public String username = "a";
    public String password = "aa";

    public synchronized void setValue(String username, String password) {
        this.username = username;
        try {
//            这里睡两秒就是为了赋值的时候有间隔，方便出现get的时候实现脏读
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
    }

    /**
     * 这里不同步的话，测试方法会打印“开始执行TestSynchronized3方法，username:b,password:aa”
     * 因为测试线程可以在对象加锁时调用未加锁的方法，此时调用getValue方法时setValue还未执行完毕，所以会产生脏读
     * 给getValue加上synchronized关键字以后，其他线程想执行getValue方法也需要等setValue方法完整的执行完毕才能再调用，此时就不会有脏读
     */
    public void getValue() {
        System.out.println("开始执行TestSynchronized3方法，username:" + username + ",password:" + password);
    }
}
