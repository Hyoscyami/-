package chapter2;

import java.util.ArrayList;
import java.util.List;

public class TestSynchronized20 {
    private List<String> list = new ArrayList<>();

    public synchronized void add(String data){
        list.add(data);
    }

    public synchronized int getSize(){
        return list.size();
    }
}
