package chapter3;

/**
 * @Author xusf
 * @Date 2020/1/13 17:23
 * @Description : 初始化ThreadLocal没set的时候调用get方法获取到的值
 */
public class TestThreadLocal4 extends ThreadLocal<String> {
    @Override
    protected String initialValue() {
        return "我是初始化的值哦";
    }
}
