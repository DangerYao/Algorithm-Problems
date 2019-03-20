package com.mixky.danger.algorithm.dp;

/**
 * 
 * 	钢铁分割
 *  1、采用递归
 *  2、采用动态规划
 * 
 * @author Danger
 *
 */
public class SteelCutting {

	public static void main(String[] args) {
		int[] p = new int[] {1,5,8,9,10,17,17,20,24,30};
		int n = 9;
		System.out.println(cutWithRecursion(p, n));
	}

	/**
	 * 	采用递归方式求解
	 * @param p 价格表数组
	 * @param n 需要分割的长度
	 * @return
	 */
	public static int cutWithRecursion(int[] p,int n) {
		if(n == 0) {
			return 0;
		}
		
		int q = Integer.MIN_VALUE;
		for (int i=1; i<=n; i++) {
			q = Math.max(q, p[i-1] + cutWithRecursion(p, n-i));
		}
		
		return q;
	}
	
	
}
