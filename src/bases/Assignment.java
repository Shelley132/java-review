package bases;

class Test {
	int t;
}
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��4�� ����10:17:46 ��˵����������Ҫ��֤����ֵ��ʵ�ʡ�
 */
public class Assignment {
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		t1.t = 1;
		t2.t = 2;
		System.out.println("Test1:" + t1.t + " Test2:" + t2.t);
		t1 = t2;
		System.out.println("Test1:" + t1.t + " Test2:" + t2.t);
	}
	/* ��������
	 * Test1:1 Test2:2 
	 * 
	 * Test1:2 Test2:2
	 */
}
