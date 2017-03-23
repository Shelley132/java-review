package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月7日 下午8:14:58
 * 类说明：
 */


class TestThreadMethod2 extends Thread {

 public static int shareVar = 0;

 public TestThreadMethod2(String name) {

   super(name);

 }

 public synchronized void run() {

   for (int i = 0; i < 4; i++) {

     System.out.println(Thread.currentThread().getName() + " : " + i);

     Thread.yield();

   }

 }

}

public class MyTest2 {

 public static void main(String[] args) {

   TestThreadMethod2 t1 = new TestThreadMethod2("t1");

   TestThreadMethod2 t2 = new TestThreadMethod2("t2");

   new Thread(t1).start();

   new Thread(t1).start();// （1）

   // new Thread(t2).start(); //（2）

 }

}