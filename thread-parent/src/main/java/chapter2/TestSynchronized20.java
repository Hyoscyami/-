package chapter2;

import java.util.ArrayList;
import java.util.List;
/**
* @Author xusf
* @Date 2020/1/8 9:21
* @Description : 测试同步代码块放到非同步代码块中进行声明，并不能保证调用方法的线程的循序性，也就是线程调用非同步代码是无序的情况下导致脏读
*/
public class TestSynchronized20 {
    private List<String> list = new ArrayList<>();

    public synchronized void add(String data){
        list.add(data);
    }

    public synchronized int getSize(){
        return list.size();
    }
}
