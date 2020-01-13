package chapter3;

import java.io.PipedOutputStream;

/**
* @Author xusf
* @Date 2020/1/13 10:52
* @Description : 通过管道进行线程间通信：字节流
*/
public class TestWriteDataThread extends Thread{
    private TestWriteData testWriteData;
    private PipedOutputStream outputStream;

    public TestWriteDataThread(TestWriteData testWriteData, PipedOutputStream outputStream) {
        this.testWriteData = testWriteData;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        super.run();
        testWriteData.writeMethod(outputStream);
    }
}
