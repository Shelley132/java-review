package tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * IO常用工具
 */
public class IOUtils {
	
	public static void replaceString(String sourceFileName, String destFileName, String sourceString, String destString){
		File source = new File(sourceFileName);
		File dest = new File(destFileName);
		try {
			InputStream fis = null;
			try {
				fis = new BufferedInputStream(new FileInputStream(source));
				byte[] buf = new byte[4096];
				StringBuffer sb1 = new StringBuffer();  
				int hasRead = 0;
				while ((hasRead = fis.read(buf)) > 0) {  
		              sb1.append(new String(buf, 0, hasRead));  
		        }  
				String s =sb1.toString();
				s = s.replace(sourceString, destString);
				writeStringToFile(dest, s);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 将输入流转换成字节流
	 * 
	 * @author LLJ
	 * @version 2017年3月17日下午2:56:21
	 * @param input
	 *            输入流
	 * @return 字节流
	 * @throws Exception IO异常
	 */
	public static byte[] toBytes(InputStream input) throws Exception {
		byte[] data = null;
		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int read = 0;
			while ((read = input.read(b)) > 0) {
				byteOut.write(b, 0, read);
			}
			data = byteOut.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
		return data;
	}

	/**
	 * 以指定编码格式将文件按行置入一个List
	 * 
	 * @author LLJ
	 * @version 2017年3月17日下午2:20:19
	 * @param fileName
	 *            要读取的文件名称
	 * @param encoding
	 *            编码方式
	 * @return 包装在List中的文件内容
	 * @throws IOException IO异常
	 */
	public static List<String> readFileToList(String fileName, String encoding) throws IOException {
		InputStreamReader insreader = null;
		BufferedReader bin = null;
		List<String> list = null;
		try {
			insreader = new InputStreamReader(new FileInputStream(fileName), encoding);
			bin = new BufferedReader(insreader);
			list = new ArrayList<String>();
			String line;
			while ((line = bin.readLine()) != null) {
				list.add(line);
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bin != null)
				bin.close();
			if (insreader != null)
				insreader.close();
		}
		return list;
	}

	/**
	 * 以utf8格式将文件按行置入一个List
	 * 
	 * @author LLJ
	 * @version 2017年3月17日下午2:21:15
	 * @param fileName
	 *            要读取的文件名称
	 * @return 包装为List的文件内容
	 * @throws IOException IO异常
	 */
	public static List<String> readFileToList(String fileName) throws IOException {
		return readFileToList(fileName, "utf8");
	}

	/**
	 * 将字符串写入指定文件
	 * 
	 * @author LLJ
	 * @version 2017年3月17日下午2:22:11
	 * @param fileName
	 *            要写入的文件名称
	 * @param content
	 *            要写入的内容
	 */
	public static void writeStringToFile(File fileName, String content) {
		File parent = fileName.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(fileName));
			out.print(content);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 将字符列表逐行存入文件
	 * 
	 * @author LLJ
	 * @version 2017年3月17日下午2:56:34
	 * @param fileName
	 *            要写入的文件名称
	 * @param strList
	 *            要写入文件的内容
	 */
	public static void writeListToFileWithLine(File fileName, List<?> strList) {
		File parent = fileName.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(fileName));
			for (int i = 0; i < strList.size(); i++) {
				out.println(strList.get(i).toString());
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 将数组元素写入文件，一个元素一行
	 * 
	 * @author LLJ
	 * @version 2017年3月17日下午3:53:09
	 * @param fileName
	 *            要写入的文件名称
	 * @param list
	 *            要写入文件的内容
	 */
	public static void writeArrayToFileWithLine(File fileName, byte[] counts) {
		File parent = fileName.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(fileName));
			for (int i = 0; i < counts.length; i++) {
				out.println(counts[i]);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 向文档末尾添加字符串
	 * 
	 * @author LLJ
	 * @version 2017年3月17日下午2:24:04
	 * @param fileName
	 *            要写入的文件名称
	 * @param content
	 *            要写入文件末尾的内容
	 */
	public static synchronized void writeStringToFileEnd(String fileName, String content) {
		FileWriter writer = null;
		try {
			String dir  = null;
			if(fileName.lastIndexOf("\\")!=-1)
				dir = fileName.substring(0, fileName.lastIndexOf("\\"));
			File file = null;
			if(dir !=null)
				file = new File(dir);
			if(file !=null && !file.exists() && !file.isDirectory()){
				file.mkdir();
			}
			writer = new FileWriter(fileName, true);
			writer.write(content);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	
	

	private static ArrayList<String> files = new ArrayList<String>();
	public static void readAllClassesUnderSpecificDir(String dirPath){
		
		File file = new File(dirPath);
		
		if (file.isDirectory()) {
			File[] lists = file.listFiles();
			for(int i = 0; i < lists.length; i++){
				if(lists[i].isFile() && lists[i].getName().endsWith("class"))
					files.add(lists[i].getAbsolutePath());
				else if(lists[i].isDirectory()){
					System.out.println();
					readAllClassesUnderSpecificDir(lists[i].getAbsolutePath());
				}
			}
		}	
	}
	public static  ArrayList<String> getFiles(){
		return IOUtils.files;
	}
	
/**
 * 删除当前路径下所有txt结尾的文件
 * @author LLJ
 * @version 2017年3月29日下午2:50:48
 * @param dirPath
 */
public static void deleteFilesUnderSpecificDir(String dirPath){
		
		File file = new File(dirPath);
		System.out.println(file.exists() +" "+ file.isDirectory());
		if (file.isDirectory()) {
			File[] lists = file.listFiles();
			for(int i = 0; i < lists.length; i++){
				System.out.println(lists[i].getName());
				if(lists[i].isFile() && lists[i].getName().endsWith(".txt")){
					lists[i].delete();
					System.out.println(lists[i].getName() + "deleted");
				}	
				else if(lists[i].isDirectory()){
					System.out.println();
					deleteFilesUnderSpecificDir(lists[i].getAbsolutePath());
				}
			}
		}	
	}
	/**
	 * 读取文件夹下所有文件名与正则表达式匹配的文件
	 * 
	 * @author LLJ
	 * @version 2017年3月20日下午4:06:33
	 * @param filePath 文件路径
	 * @param regex 正则表达式
	 * @return 文件路径下所有的满足特定正则表达式的文件列表
	 * @throws FileNotFoundException 文件未找到，检查路径是否正确
	 * @throws IOException IO异常
	 */
	public static String[] readFiles(String filePath, String regex) throws FileNotFoundException, IOException {
		String[] files = null;
		File file = new File(filePath);
	
		if (file.isDirectory()) {
			String[] lists = file.list(new MyFilter(regex));
			if(lists !=null){
				files = new String[lists.length];
			}
			for(int i = 0; i < lists.length; i++){
				if(filePath.endsWith("\\")){
					files[i] = filePath+lists[i];
				}else{
					files[i] = filePath+"\\"+lists[i];
				}
				
			}
				
		}
		return files;
	}
	
	/**
	 * 删除文件夹下所有文件名与正则表达式匹配的文件
	 * 
	 * @author LLJ
	 * @version 2017年3月20日下午4:06:33
	 * @param filePath 文件路径
	 * @param regex 正则表达式
	 * @return 文件路径下所有的满足特定正则表达式的文件列表
	 * @throws FileNotFoundException 文件未找到，检查路径是否正确
	 * @throws IOException IO异常
	 */
	public static void deleteFiles(String filePath, String regex) throws FileNotFoundException, IOException {
		String[] files = null;
		File file = new File(filePath);
	
		if (file.isDirectory()) {
			String[] lists = file.list(new MyFilter(regex));
			if(lists !=null){
				files = new String[lists.length];
			}
			for(int i = 0; i < lists.length; i++){
				if(filePath.endsWith("\\")){
					files[i] = filePath+lists[i];
				}else{
					files[i] = filePath+"\\"+lists[i];
				}
				
			}
				
		}
	}

	/**
	 * 从文件fileName中读取对象写入List
	 * 
	 * @author LLJ
	 * @version 2017年3月22日下午2:53:58
	 * @param fileName
	 *            要读取的文件的名称
	 * @return 从文件中读取的数据ArrayList
	 */
	public static ArrayList readObjectToList(String fileName) {
		ArrayList list = new ArrayList();
		ObjectInputStream oin = null;
		try {
			oin = new ObjectInputStream(new FileInputStream(fileName));
			try {
				while (true) {
					Object o = oin.readObject();
					list.add(o);
				}
			} catch (EOFException e) {
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(oin!=null)
					oin.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return list;
	}

	/**
	 * 将链表中的Object写入文件，即序列化
	 * 
	 * @author LLJ
	 * @version 2017年3月20日下午7:18:47
	 * @param <T>
	 * @param tcs
	 *            要写入文件的ArrayList
	 * @param fileName
	 *            要写入的文件的名称
	 * @return 是否写入成功
	 */
	public static <T> boolean writeListToFile(ArrayList<T> tcs, String fileName) {
		File file = new File(fileName);
		ObjectOutputStream oout = null;
		try {
			oout = new ObjectOutputStream(new FileOutputStream(file));
			for (int i = 0; i < tcs.size(); i++) {
				Object obj = tcs.get(i);
				oout.writeObject(obj);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oout != null) {
					oout.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 写一个对象到文件中
	 * 
	 * @author LLJ
	 * @version 2017年3月20日下午7:18:02
	 * @param obj
	 *            Object对象实例
	 * @param fileName
	 *            文件名
	 * @return 写入是否成功
	 */
	public static boolean writeObjectToFile(Object obj, String fileName) {
		File file = new File(fileName);
		boolean isexist = false;
		if (file.exists())
			isexist = true;
		long pos = 0;
		ObjectOutputStream out = null;
		FileOutputStream fo =  null;
		try {
			fo = new FileOutputStream(file, true);

			out = new ObjectOutputStream(fo);
			if (isexist) {
				pos = fo.getChannel().position() - 4;
				fo.getChannel().truncate(pos);
			}
			out.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				
				if (out != null) {
					out.close();
				}
				if(fo!=null){
					fo.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * 复制源文件到目标文件
	 * 
	 * @author LLJ
	 * @version 2017年4月19日下午1:22:09
	 * @param sourceFileName
	 *            源文件名称
	 * @param destFileName
	 *            目的文件名称
	 */
	public static void copyFile(String sourceFileName, String destFileName, String header) {
		File source = new File(sourceFileName);
		File dest = new File(destFileName);
		if (!dest.exists()) {
			// 如果目标文件所在目录不存在，则创建目录
			if (!dest.getParentFile().exists()) {
				// 目标文件所在目录不存在
				dest.getParentFile().mkdirs();
			}
		}
		String pac = sourceFileName.substring(0,sourceFileName.lastIndexOf("\\"));
		
		String name = pac.substring(pac.lastIndexOf("\\")+1);
		try {
			InputStream fis = null;
			OutputStream fos = null;
			try {
				fis = new BufferedInputStream(new FileInputStream(source));
				fos = new BufferedOutputStream(new FileOutputStream(dest));
				byte[] buf = new byte[4096];
				int i;
				
				fos.write(header.getBytes(),0, header.getBytes().length);
				while ((i = fis.read(buf)) != -1) {
					fos.write(buf, 0, i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fos.close();
				fis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 把
	 * @author LLJ
	 * @version 2017年5月12日上午10:14:27
	 * @param fileName
	 * @param bugList
	 */
	public static void writeStringListToFile(String fileName, ArrayList<String> list) {
		// TODO Auto-generated method stub
		FileWriter writer = null;
		try {
			String dir  = null;
			if(fileName.lastIndexOf("\\")!=-1)
				dir = fileName.substring(0, fileName.lastIndexOf("\\"));
			File file = null;
			if(dir !=null)
				file = new File(dir);
			if(file !=null && !file.exists() && !file.isDirectory()){
				file.mkdir();
			}
			writer = new FileWriter(fileName, true);
			for(int i=0; i< list.size(); i++)
				writer.write(list.get(i));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	} 
}

class MyFilter implements FilenameFilter{
	private String regex;
	public MyFilter(String regex){
		this.regex = regex;
	}
	@Override
	public boolean accept(File dir, String name) {
		
		return name.contains(regex);
	}
}