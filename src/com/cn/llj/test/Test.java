package com.cn.llj.test;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年5月26日 下午8:56:12
 * 类说明：
 */
import java.util.Scanner;

import java.util.regex.MatchResult;



 class Test {

     

     public static void main(String[] args) {

         Scanner s = new Scanner("Das ist ein Test");

         s.findInLine("(\\w+) ist (\\w+)");

         MatchResult m = s.match();

         for (int i = 0; i < m.groupCount(); i++)

         {

             System.out.println(m.start(i) + ":" + m.group(i));

         }

         StringBuffer str = new StringBuffer();
     }

 }
