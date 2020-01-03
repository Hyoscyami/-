package chapter1;
/**
* @Author xusf
* @Date 2019/10/29 13:51
* @Description : 实现Runnable
*/
public class SecondThread implements Runnable{

    @Override
    public void run() {
        System.out.println("实现Runnable");
    }
}
