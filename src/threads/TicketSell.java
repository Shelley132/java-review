package threads;

/**
 * @author JUANJUAN
 * @version 2017年10月11日上午10:15:57
 */
public class TicketSell {

	public static void main(String[] args) { 
	    TicketWindow tw = new TicketWindow(); 
	    Thread t1 = new Thread(tw, "一号窗口"); 
	    Thread t2 = new Thread(tw, "二号窗口"); 
	    Thread t3 = new Thread(tw, "三号窗口"); 
	    t1.start(); 
	    t2.start(); 
	    t3.start(); 
	  } 
	} 
	 
	class TicketWindow implements Runnable { 
	  private int tickets = 10; 
	 
	  @Override 
	  public synchronized  void run() { 
	    while (true) { 
	      if (tickets > 0) { 
	        System.out.println("还剩余票:" + tickets + "张"); 
	        tickets--; 
	        System.out.println(Thread.currentThread().getName() + "卖出一张火车票,还剩" + tickets + "张"); 
	      } else { 
	        System.out.println("余票不足,暂停出售!"); 
//	        wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用 
	        try { 
	          Thread.sleep(1000); 
	        } catch (InterruptedException e) { 
	          e.printStackTrace(); 
	        } 
	      } 
	    } 
	} 
}
