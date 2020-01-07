package chapter2;
/**
* @Author xusf
* @Date 2020/1/7 10:11
* @Description : 测试同步代码块，即当方法中有阻塞时间过长的内容直接同步方法会使并发急剧下降，此时可以同步会出现线程不安全的代码块，提升并发量
*/
public class TestSynchronized15 {
    private String username;
    private String password;

    /**
     * 改良前
     * @param username
     * @param password
     */
    public synchronized void setValue(String username,String password){
        long beginTime = System.currentTimeMillis();
        System.out.println("线程:" + Thread.currentThread().getName() + "开始执行setValue方法，时间戳:" + beginTime);
        try {
//            模拟执行任务
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:" + Thread.currentThread().getName() + "模拟执行耗时长的任务完成，开始赋值，时间戳:" + System.currentTimeMillis());
        this.username = username;
        try {
//            这里睡是为了更好地凸显出线程不安全
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        long endTime = System.currentTimeMillis();
        System.out.println("线程：" + Thread.currentThread().getName() + "赋值完毕，时间戳：" + endTime + "总耗时:" + (endTime - beginTime));
    }

    /**
     * 改良后
     * @param username
     * @param password
     */
    public void setValue2(String username,String password){
        long beginTime = System.currentTimeMillis();
        System.out.println("线程:" + Thread.currentThread().getName() + "开始执行setValue2方法，时间戳:" + beginTime);
        try {
//            模拟执行任务
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:" + Thread.currentThread().getName() + "模拟执行耗时长的任务完成，开始赋值，时间戳:" + System.currentTimeMillis());
        synchronized (this){
            this.username = username;
            try {
//            这里睡是为了更好地凸显出线程不安全
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.password = password;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("线程：" + Thread.currentThread().getName() + "赋值完毕，时间戳：" + endTime + "总耗时:" + (endTime - beginTime));
    }
}
