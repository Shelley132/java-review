package com.cn.llj.test;
import java.util.Date; 
public class SuperTest extends Date{ 
    private static final long serialVersionUID = 1L; 
    private void test(){ 
       System.out.println(super.getClass().getName()); 
       System.out.println(this.getClass().getSuperclass().getName()); 
    } 
     
    public static void main(String[]args){ 
       new SuperTest().test();
    } 
}