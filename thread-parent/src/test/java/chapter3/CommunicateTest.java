package chapter3;

import org.junit.Test;

import java.io.*;

/**
 * @Author xusf
 * @Date 2020/1/13 10:45
 * @Description : 测试通过管道进行线程间通信
 */
public class CommunicateTest {
    /**
     * 通过管道进行线程间通信：字节流
     */
    @Test
    public void test() {
        TestWriteData writeData = new TestWriteData();
        TestReadData readData = new TestReadData();
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        try {
            outputStream.connect(inputStream);
//            这里是先读，然后再有写数据
            TestReadDataThread testReadDataThread = new TestReadDataThread(readData, inputStream);
            testReadDataThread.start();
            Thread.sleep(1000);
            TestWriteDataThread testWriteDataThread = new TestWriteDataThread(writeData, outputStream);
            testWriteDataThread.start();
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过管道进行线程间通信：字符流
     */
    @Test
    public void test2() {
        TestWriteData writeData = new TestWriteData();
        TestReadData readData = new TestReadData();
        PipedReader inputStream = new PipedReader();
        PipedWriter outputStream = new PipedWriter();
        try {
            outputStream.connect(inputStream);
//            这里是先读，然后再有写数据
            TestReadDataThread2 testReadDataThread = new TestReadDataThread2(readData, inputStream);
            testReadDataThread.start();
            Thread.sleep(1000);
            TestWriteDataThread2 testWriteDataThread = new TestWriteDataThread2(writeData, outputStream);
            testWriteDataThread.start();
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
