package command;
/**
 * @author JUANJUAN
 * @version 2017年8月7日下午8:14:23
*/
import java.util.ArrayList;
import java.util.List;
//接收命令，给谁处理
   public class Broker {
   private List<Order> orderList = new ArrayList<Order>(); 

   public void takeOrder(Order order){
      orderList.add(order);		
   }

   public void placeOrders(){
      for (Order order : orderList) {
         order.execute();
      }
      orderList.clear();
   }
}