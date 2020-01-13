package chapter3;

import java.io.PipedWriter;
/**
* @Author xusf
* @Date 2020/1/13 11:30
* @Description : 通过管道进行线程间通信：字符流
*/
public class TestWriteDataThread2 extends Thread{
    private TestWriteData testWriteData;
    private PipedWriter pipedWriter;

    public TestWriteDataThread2(TestWriteData testWriteData, PipedWriter pipedWriter) {
        this.testWriteData = testWriteData;
        this.pipedWriter = pipedWriter;
    }

    @Override
    public void run() {
        super.run();
        testWriteData.writeMethod(pipedWriter);
    }
}
