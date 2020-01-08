package chapter2;
/**
* @Author xusf
* @Date 2020/1/8 9:23
* @Description : 测试常量池特性对synchronized的影响
*/
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
