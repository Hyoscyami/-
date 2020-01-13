package chapter3;

import java.io.PipedInputStream;

/**
 * @Author xusf
 * @Date 2020/1/13 10:54
 * @Description : 通过管道进行线程间通信：字节流
 */
public class TestReadDataThread extends Thread {
    private TestReadData testReadData;
    private PipedInputStream inputStream;

    public TestReadDataThread(TestReadData testReadData, PipedInputStream inputStream) {
        this.testReadData = testReadData;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        super.run();
        testReadData.readMethod(inputStream);
    }
}
