/**
 * 
 */
package com.priyam.dynamicprogramming;

/**
 * @author prigupta8
 *
 */
public class SubsetSum {

	public static void main(String...strings) {
		int[] arr = { 7, 3, 2, 5, 8 };
		int sum = 14;
		System.out.println(SS(arr, 0, sum));
	}
	
	public static boolean SS(int arr[], int i, int sum) {
		if(sum == 0)
			return true;
		if(i == arr.length || sum < 0)
			return false;
		
		boolean inc = SS(arr, i + 1, sum - arr[i]);
		
		boolean exc = SS(arr, i + 1, sum);
		
		return inc || exc;
		
	}
}
