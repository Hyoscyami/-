package chapter3;

public class TestWait16 extends Thread{
    private TestConsume testConsume;

    public TestWait16(TestConsume testConsume) {
        this.testConsume = testConsume;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testConsume.consume();
        }
    }
}
