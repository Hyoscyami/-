# 多线程汇总
##目录结构：
#### src/main/java下是代码，src/test/java下是对应章节线程的不同用法。
#### chapter1：
1. 多线程基础语法，包含了三种实现多线程的方式。
2. FirstThread、SecondThread、ThirdThread分别是继承Thread，实现Runnable，实现Callable
其他的方法
3. 其他的类分别是测试基础方法的线程类，测试内容与名字相关，如TestCurrentThread是测试CurrentThread方法
#### chapter2：
1. 主要是synchronized和volatile的一些用法
2. TestSynchronized和TestSynchronized2是用来测试多个线程修改成员变量未同步导致的线程安全问题
3. TestSynchronized3和TestSynchronized4是用来测试只同步set方法不同步get方法导致的脏读问题
4. TestSynchronized5和TestSynchronized6是用来测试synchronized关键字可重入特性
5. TestSynchronized7、TestSynchronized8和TestSynchronized9用来测试synchronized关键字可重入特性也支持父子继承
6. TestSynchronized10和TestSynchronized11测试出现异常会自动释放锁
7. TestSynchronized12、TestSynchronized13和TestSynchronized14测试同步不具有继承性，即父类方法加了synchronized，子类重写该方法时不加synchronized，多线程执行子类方法时不会同步
8. TestSynchronized15和TestSynchronized16测试同步方法中有阻塞方法时只同步可能会引起线程不安全的代码块
9. TestSynchronized17、TestSynchronized18和TestSynchronized19测试synchronized代码块之间的同步性，即同一个对象的锁被占用，另一个线程不能访问所有被加锁的方法
10. TestSynchronized20、TestSynchronized21和TestSynchronized22测试同步代码块放到非同步代码块中进行声明，并不能保证调用方法的线程的循序性，也就是线程调用非同步代码是无序的情况下导致脏读
11. TestSynchronized23和TestSynchronized24测试常量池特性对synchronized的影响
12. TestSynchronized25、TestSynchronized26和TestSynchronized27测试锁同一个对象后同步方法A长时间阻塞（极端情况如死循环），导致其他同步方法长时间无法执行