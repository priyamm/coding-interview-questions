/**
 * 
 */
package com.priyam.dynamicprogramming;

/**
 * @author prigupta8
 *
 */
public class CuttingRod {
	
	/**
	 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
	 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
	 * For example, if length of the rod is 8 and the values of different pieces are given as following, 
	 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
	 * 
	 * 	length   | 1   2   3   4   5   6   7   8  
		--------------------------------------------
		price    | 1   5   8   9  10  17  17  20
	 * 
	 */

	public static void main(String...strings) {
		
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		
		System.out.println(solveCuttingRod(arr));
		
	}

	/**
	 * @param arr
	 */
	private static int solveCuttingRod(int[] arr) {
		
		int ans[] = new int[arr.length + 1];
		ans[0] = 0;
		
		for(int i = 1 ; i <= arr.length ; i++) {
			
			for(int j = 0; j < i ; j++) {
				ans[i] = Math.max(ans[i], arr[j] + ans[i - j - 1]);
			}
		}
		return ans[ans.length - 1];
	}
	
	
}
