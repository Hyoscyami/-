package chapter1;
/**
* @Author xusf
* @Date 2019/10/29 11:06
* @Description : 继承Thread实现
*/
public class FirstThread extends Thread{

    public FirstThread(){

    }
    public FirstThread(String threadName){
        this.setName(threadName);
    }
    @Override
    public void run(){
        System.out.println("线程名为:" + Thread.currentThread().getName() + "继承了Thread");
    }
}
