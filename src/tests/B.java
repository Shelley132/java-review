package tests;
/**
 * @author 刘利娟 liulijuan@gmail.com
 * @version 创建时间年月日 下午
 * 类说明：
 */

class A { 
		  
		     private String value; 
		  
		     public A() {} 
		  
		     public A(String value) { 
		         this.value = value; 
		     } 
		  
		     public String getValue() { 
		         return value; 
		     } 
		  
		     public void setValue(String value) { 
		         this.value = value; 
		     } 
		 } 

		 public class B extends A { 
		  
		     public static void main(String args[]){ 
		         B b = new B(); 
		         b.setValue("b1"); 
		         //B b2 = new B("b2"); 
		         System.out.println(b.getValue()); 
		         System.out.println(b.getValue());   
		     } 
		 } 

