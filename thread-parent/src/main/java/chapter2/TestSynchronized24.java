package chapter2;

public class TestSynchronized24 extends Thread{
    private TestSynchronized23 testSynchronized23;
    private String name;

    public TestSynchronized24(TestSynchronized23 testSynchronized23,String name){
        this.testSynchronized23 = testSynchronized23;
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        testSynchronized23.method(name);
    }
}
