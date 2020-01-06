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
4. 