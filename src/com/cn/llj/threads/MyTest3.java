package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月7日 下午8:26:44
 * 类说明：
 */


class TestThreadMethod3 extends Thread {

 public int shareVar = 0;

 public TestThreadMethod3(String name) {

   super(name);

   new Notifier(this);

 }

 public synchronized void run() {

   if (shareVar == 0) {

     for (int i = 0; i < 5; i++) {

       shareVar++;

       System.out.println("i = " + shareVar);

       try {

         System.out.println("wait......");

         this.wait();

       } catch (InterruptedException e) {}

     }

   }

 }

}

class Notifier extends Thread {

 private TestThreadMethod3 ttm;

 Notifier(TestThreadMethod3 t) {

   ttm = t;

   start();

 }

 public void run() {

   while (true) {

     try {

       sleep(2000);

     } catch (InterruptedException e) {}

     /* 1 要同步的不是当前对象的做法 */

     synchronized (ttm) {

       System.out.println("notify......");

       ttm.notify();

     }

   }

 }

}

public class MyTest3 {

 public static void main(String[] args) {

   TestThreadMethod3 t1 = new TestThreadMethod3("t1");

   t1.start();

 }

}
