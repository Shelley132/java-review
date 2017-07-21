package bases.overrides;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月17日 上午10:08:19
 * 类说明：
 */

public class Test3 {
	public static void main(String[] args) {
		int[] k = new int[] { 10, 100, 32, 45, 58, 126, 3, 29, 200, 400, 0 };
		int[] n = new int[k.length];
		int[] hash = new int[13];
		createHashTable(k, n, hash);
		System.out.println("------------------");
		getNumber(hash, 32);
		getNumber(hash, 1000);
	}
	
	private static void getNumber(int[] hash, int i) {
		int k = i % 13;
		while (hash[k] != i) {
			k ++;
			if (k == 13) {//回到表头
				k = 0;
			}
			if (hash[k] == 13) {
				System.out.println("没有你找的数！");
				return;
			}
		}
		System.out.println(hash[k]);
	}

	private static void createHashTable(int[] k, int[] n, int[] hash) {
		for (int i = 0; i < k.length; i++) {
			n[i] = k[i] % 13;//13
		}
		for (int i = 0; i < hash.length; i ++) {
			hash[i] = 13;//初始化
		}
		for (int i = 0; i < k.length; i++) {
			if (hash[n[i]] == 13) {
				hash[n[i]] = k[i];
			} else {
				while (hash[n[i]] != 13) {//处理冲突
					if (n[i] == hash.length) {//循环到开始处
						n[i] = 0;
					}
					n[i]++;
				}
				hash[n[i]] = k[i];
			}
		}
		for (int i = 0; i < k.length; i++) {
			System.out.println(hash[i]);
		}
		
	}
}
