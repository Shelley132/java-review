package leetcodes;

import java.util.Arrays;

/**
 * @author JUANJUAN
 * @version 2017年5月15日上午11:19:56
 */
public class Knapsack {
	public static void main(String[] args) {
		int m = 10;
		int n = 4;
		int w[] = { 5, 2, 8, 1 };
		int p[] = { 7, 3, 10, 4 };
		System.out.println("二维数组不一定装满背包：" + knapsack2(m, n, w, p));

		System.out.println("一维数组不一定装满背包：" + knapsack1(m, n, w, p));

		System.out.println("一维数组必须装满背包：" + knapsackFull1(m, n, w, p));
		// printPack(c, w, m, n);

	}

	/**
	 * 不一定装满背包的算法
	 * 
	 * @param m
	 *            表示背包的最大容量
	 * @param n
	 *            表示商品个数
	 * @param w
	 *            表示商品重量数组
	 * @param p
	 *            表示商品价值数组
	 */
	public static int knapsack2(int m, int n, int[] w, int[] p) {
		// c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
		int c[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++)
			c[i][0] = 0;
		for (int j = 0; j < m + 1; j++)
			c[0][j] = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				// 当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
				// (1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
				// (2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
				if (w[i - 1] <= j) {
					if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
						c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
					else
						c[i][j] = c[i - 1][j];
				} else
					c[i][j] = c[i - 1][j];
			}
		}
		return c[n][m];
	}

	/**
	 * @param m
	 *            表示背包的最大容量
	 * @param n
	 *            表示商品个数
	 * @param w
	 *            表示商品重量数组
	 * @param p
	 *            表示商品价值数组
	 */
	public static int knapsackFull1(int m, int n, int[] w, int[] p) {
		//
		int dp[] = new int[m + 1];
		dp[0] = 0;
		for (int j = 1; j < m + 1; j++)
			dp[j] = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = m; j >= w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + p[i]);

			}

		}
		System.out.println(Arrays.toString(dp));
		return dp[dp.length - 1];
	}

	public static int knapsack1(int m, int n, int[] w, int[] p) {
		//
		int dp[] = new int[m + 1];
		for (int j = 0; j < m + 1; j++)
			dp[j] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = m; j >= w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + p[i]);

			}

		}
		System.out.println(Arrays.toString(dp));
		return dp[dp.length - 1];
	}
}