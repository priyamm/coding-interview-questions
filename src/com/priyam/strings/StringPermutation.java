/**
 * 
 */
package com.priyam.strings;

/**
 * @author prigupta8
 *
 */
public class StringPermutation {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		String str = "Priyam";
		sp.findPermutations(str);
	}

	/**
	 * @param str
	 */
	private void findPermutations(String str) {
		permute(str, "");
	}

	/**
	 * @param str
	 * @param string
	 * @return
	 */
	private void permute(String word, String perm) {
		if(word.isEmpty()) 
			System.out.println(perm + word);
		else
		for(int i = 0 ; i < word.length() ; i++) {
			permute(word.substring(0, i) + word.substring(i + 1), perm + word.charAt(i));
		}
	}

}
