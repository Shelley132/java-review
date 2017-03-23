package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月20日下午2:34:48
*/
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Main {
    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    public static void main(String[] args) {
        int timeLimit = 5; // 预计TaskA执行不得超过5秒。
        // CASE 1：TaskA的执行时间没有超时。
        check(new TaskA("111", 3), timeLimit);
        // CASE 2：TaskA的执行时间超时，被强制终止。
        check(new TaskA("222", 7), timeLimit);
    }
    @SuppressWarnings("deprecation")
    public static void check(TaskA taskA, int timeLimit) {
        Thread subThread = new Thread(taskA);
        subThread.start(); // 启动子线程
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        boolean timeout = endTime - startTime > timeLimit * 1000;
        try {
            // 如果子线程未运行完毕，且未超时，则继续等待子线程。
            while (subThread.isAlive() && !timeout) {
                subThread.join(1000);
                endTime = System.currentTimeMillis();
                timeout = endTime - startTime > timeLimit * 1000;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("timeout");
        if (timeout) {
            // 虽然该方法不推荐，但是对陷入死循环的线程也只能使用此方法来结束线程了。
            subThread.stop();
            String now = sdf.format(Calendar.getInstance().getTime());
            System.out.println(now + " - " + taskA.name
                    + " is timeout and is stopped.");
        }
    }
    public static class TaskA implements Runnable {
        private String name = "";
        private int count = 0;
        public TaskA(String name, int count) {
            this.name = name;
            this.count = count;
        }
        public void run() {
            // 开始日志
            String now = sdf.format(Calendar.getInstance().getTime());
            System.out.println(now + " - " + name + " started.");
            // 模拟业务操作
            try {
                Thread.sleep(1000 * count);
            } catch (InterruptedException e) {
                now = sdf.format(Calendar.getInstance().getTime());
                System.out.println(now + " - " + name + " is interrupted.");
            }
            // 结束日志
            now = sdf.format(Calendar.getInstance().getTime());
            System.out.println(now + " - " + name + " ended.");
        }
    }
}
