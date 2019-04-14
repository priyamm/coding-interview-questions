/**
 * 
 */
package com.priyam.dynamicprogramming;

/**
 * @author prigupta8
 *
 */
public class LongestIncreasingSubsequence {
	
//	public static int longIncreasingSubs(int[] arr, int i, int last, int length) {
//		
//		if(i == n)
//			return 0;
//		
//		int excl = longIncreasingSubs(arr, i + 1, length);
//		
//		if(arr[i] > last) {
//			int incl = longIncreasingSubs(arr, i, length + 1);
//		}
//		
//		return Math.max(incl, excl);
//		
//	}

	
	public static void main(String...strings) {
		int arr[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		
		System.out.println(LIS(arr, 0, Integer.MIN_VALUE));
	}

/**
 * @param arr
 * @param i
 * @param minValue
 * @param j
 * @return
 */
private static int LIS(int[] arr, int index, int prev) {
	int ans[] = new int[arr.length];
	ans[0] = 1;
	
	for(int i = 1; i < arr.length ; i++) {
		
		for(int j = 0 ; j < i ; j++) {
			if(arr[j] < arr[i] && ans[i] < ans[j]) 
				ans[i] = ans[j];
		}
		ans[i] ++;
	}
	
	 int max = ans[0];
     for(int i = 0; i < ans.length; i++)
     {
         if(max < ans[i])
         {
             max = ans[i];
         }
     }
     
	return max;
}
}
