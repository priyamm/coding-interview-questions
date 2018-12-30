/**
 * 
 */
package com.priyam.strings;

/**
 * @author prigupta8
 *
 */
public class StringReverse {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringReverse sr = new StringReverse();
		String str = "Hello";
		
		// string reverse by using StringBuilder
		StringBuilder sb = new StringBuilder(str);
		System.out.print(sb.reverse().toString());
		
		
		// string reverse by using recursion
		System.out.print(sr.reverse(str));

	}
	
	public String reverse(String str) {
		if(str.isEmpty())
			return "";
		return reverse(str.substring(1)) + str.substring(0, 1);
	}

}
