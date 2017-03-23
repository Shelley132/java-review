package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月7日 下午8:10:50
 * 类说明：
 */


class TestThreadMethod extends Thread {

 public static int shareVar = 0;

 public TestThreadMethod(String name) {

   super(name);

 }

 public synchronized void run() {

   for (int i = 0; i < 5; i++) {

     System.out.println(Thread.currentThread().getName() + " : " + i);
     try {

       if (Thread.currentThread().getName().equals("t1"))

         Thread.sleep(2000);

       else

         Thread.sleep(1000);

     } catch (InterruptedException e) {

       System.out.println("Interrupted");

     }

   }

 }

}

public class MyTest {

 public static void main(String[] args) {

   TestThreadMethod t1 = new TestThreadMethod("t1");

   TestThreadMethod t2 = new TestThreadMethod("t2");

   t1.start();

   // t1.start();

   t2.start();

 }

}