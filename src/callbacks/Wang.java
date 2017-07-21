package callbacks;
/**
 * @author LLJ
 * @version 2017年3月24日上午10:31:16
 */
public class Wang implements CallBack {
	private Li li;
	public Wang(Li li) {
		this.li = li;
	}
	public void askQuestion(final String question) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				li.executeMessage(Wang.this, question);
			}
		}).start();
		play();
	}
	public void play() {
		System.out.println("我要逛街去了");
	}
	/**
	 * 小李知道答案后调用此方法告诉小王，就是所谓的小王的回调方法
	 */
	@Override
	public void solve(String result) {
		System.out.println("小李告诉小王的答案是--->" + result);
	}

}
