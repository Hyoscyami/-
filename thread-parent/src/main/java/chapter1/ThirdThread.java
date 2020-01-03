package chapter1;

import java.util.concurrent.Callable;
/**
* @Author xusf
* @Date 2019/10/29 13:55
* @Description : 实现callable
*/
public class ThirdThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
