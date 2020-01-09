package chapter3;

public class TestWait17 extends Thread{
    private TestProduct testProduct;

    public TestWait17(TestProduct testProduct) {
        this.testProduct = testProduct;
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
            testProduct.product();
        }
    }
}
