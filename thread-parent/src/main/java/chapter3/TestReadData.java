package chapter3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

/**
* @Author xusf
* @Date 2020/1/13 10:37
* @Description : 通过管道进行线程间通信：字节流
*/
public class TestReadData {
    public void readMethod(PipedInputStream pipedInputStream){
        byte[] bytes = new byte[1024];
        try {
//            没数据的时候，就阻塞到了这里
            System.out.println("等待读取信息：");
            int readLength = pipedInputStream.read(bytes);
            while (readLength != - 1){
                String newData = new String(bytes,0,readLength);
                System.out.print("读到啦数据:" + newData);
                readLength = pipedInputStream.read(bytes);
            }
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMethod(PipedReader pipedReader){
        char[] bytes = new char[1024];
        try {
//            没数据的时候，就阻塞到了这里
            System.out.println("等待读取信息：");
            int readLength = pipedReader.read(bytes);
            while (readLength != - 1){
                String newData = new String(bytes,0,readLength);
                System.out.print("读到啦数据:" + newData);
                readLength = pipedReader.read();
            }
            pipedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
