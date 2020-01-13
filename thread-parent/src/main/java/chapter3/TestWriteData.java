package chapter3;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

/**
* @Author xusf
* @Date 2020/1/13 10:21
* @Description : 通过管道进行线程间通信：字节流
*/
public class TestWriteData {
    public void writeMethod(PipedOutputStream outputStream){
        try {
            System.out.println("开始写入信息：");
            outputStream.write("开始写入信息啦".getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMethod(PipedWriter pipedWriter){
        try {
            System.out.println("开始写入信息：");
            pipedWriter.write("开始写入信息啦");
            pipedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
