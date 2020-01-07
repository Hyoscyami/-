package chapter2;

public class TestSynchronized21 {
    /**
     * 这里之所以可能会产生脏读，是因为这个方法没有进行同步，当线程在testSynchronized20.add阻塞的时候，其他线程可以调用该方法,此时多个线程都看到了size<1，然后开始执行新增方法
     * @param testSynchronized20
     * @param data
     * @return
     */
    public TestSynchronized20 addMethod(TestSynchronized20 testSynchronized20,String data){
        if (testSynchronized20.getSize() < 1){
            try {
//                为了更容易看到线程不安全导致的后果，睡一秒，这里会因为第一个线程发现符合条件打算新增还未新增的时候，第二个线程也发现符合条件，也进入了方法，导致新增多条
//                为了解决这个问题可以锁testSynchronized20,这个例子中testSynchronized20是同一个对象，如果所锁的是这个方法的话，执行方法的对象不同，起不到作用
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testSynchronized20.add(data);
        }
        return testSynchronized20;
    }
}
