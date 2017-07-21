package ios;
import java.io.*;
/**
 *1�� �������Ŀ�� ����дһ����������������ӦΪ��ĸ��̴�д��ĸ��Ȼ�󽫽��д�뵽һ�����������ĺ������������������һ���ַ����е����е��ַ�ת���ɴ�д
 *2�� System.in ���ӵ����̣���InputStream���͵�ʵ������ System.out ���ӵ���ʾ������PrintStream���ʵ������
 *3�����ܸ��ֵײ������豸��ʲô��ʽʵ�����ݵ���ֹ�㣬InputStream��read�������Ƿ���-1����ʾ�������Ľ���
 *4�� ��windows�£�����crrl+z��ϼ����Բ��������������Ľ�����ǣ���linux�£����ǰ���ctrl+d��ϼ������������Ľ������
 *5������ ��̴Ӽ�����������ȡһ�������ʱ��Ӧ��������ȡ�Ĺ��̷��ں�������ɣ�ʹ��-1����Ϊ��������Ľ����㣬�ڸú����б�д�ĳ�����벻Ӧֱ��ʹ��System.in��ȡ���ݣ�������һ��InputStream���͵���ʽ��������ȡ���ݣ�Ȼ��System.in��Ϊʵ�δ��ݸ�InputStream���͵���ʽ���������øú���
     *6����Ļ�Ĺ���Ҳ��������ByteArrayInputStream��ByteArrayOutputStream��ʵ��
 */
public class ByteArrayTest {
	/**
	 * ʹ��ƽ̨��Ĭ���ַ������� String ����Ϊ byte ���У���������洢��һ���µ� byte �����С�
	 * �����ַ�������ʹ��Ĭ�ϵ��ַ�������ʱ���˷�������Ϊû��ָ����
	 * �����Ҫ�Ա�����̽��и�����ƣ���Ӧ��ʹ�� CharsetEncoder �ࡣ 
	 * ByteArrayInputStream ����һ���ڲ����������û��������������ж�ȡ���ֽڡ�
	 * �ڲ����������� read ����Ҫ�ṩ����һ���ֽڡ� 
	 * �ر� ByteArrayInputStream ��Ч��
	 * �����еķ����ڹرմ������Կɱ����ã�����������κ� IOException�� 
	 * */
	public static void main(String[] args) {
		String stp = "abcdefghigh";
		
		byte buf [] = stp.getBytes();
		
		ByteArrayInputStream input = new ByteArrayInputStream(buf);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		transForm(input,output);
		byte resault [] = output.toByteArray();
		System.out.println(new String(resault));//���ֽ������е�����Ԫ���ó���ת�����ַ���		
		transForm(System.in,System.out);//���Ӽ��������Сд��ĸת���ɴ�д����ĸ
		
	}
	
	/**
	 * @param in InputStream
	 * 			������
	 * @param out OutputStream
	 * 			�����
	 */
	public static void transForm(InputStream in,OutputStream out){
		int info = 0;
		try {
			while((info = in.read()) != -1){
				//��ȡ��Ϣ
				int uppInfo = Character.toUpperCase((char)info);
				//�� �������ֽ���Ϣ ת���ɴ�д
				out.write(uppInfo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

