/**
 * 
 */
package com.priyam.dynamicprogramming;

/**
 * @author prigupta8
 *
 */
public class MaxSubArraySum {
	
	// maximum sum of a contaiguous subarray
	// {2, 9, -5, 1, 10}
	
	// Kadane's Algorithm
	/**
	 * @param num
	 * @return
	 */
	private static int maximumSum(int[] num) {
		
		int max_so_far = 0;
		int current_max = 0;
		
		for(int i = 0; i < num.length; i++) {
			current_max += num[i];
			if(current_max > max_so_far) 
				max_so_far = current_max;
			if(current_max < 0) {
				current_max = 0;
			}
		}
		return max_so_far;
	}
	
	
	
	public static void main(String... strings) {
		int num[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maximumSum2(num));
		
	}



	/**
	 * @param num
	 * @return
	 */
	private static int maximumSum2(int[] num) {
		int max_so_far = num[0];
		int curr_max = num[0];
		
		for(int i = 1 ; i < num.length ; i++) {
			curr_max = Math.max(num[i], curr_max + num[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

}
