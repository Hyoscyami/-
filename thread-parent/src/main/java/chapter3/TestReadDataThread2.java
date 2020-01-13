package chapter3;

import java.io.PipedReader;

/**
 * @Author xusf
 * @Date 2020/1/13 11:28
 * @Description : 通过管道进行线程间通信：字符流
 */
public class TestReadDataThread2 extends Thread {
    private TestReadData testReadData;
    private PipedReader pipedReader;

    public TestReadDataThread2(TestReadData testReadData, PipedReader pipedReader) {
        this.testReadData = testReadData;
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
        super.run();
        testReadData.readMethod(pipedReader);
    }
}
