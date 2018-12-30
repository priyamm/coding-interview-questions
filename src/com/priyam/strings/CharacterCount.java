/**
 * 
 */
package com.priyam.strings;

import java.util.HashMap;

/**
 * @author prigupta8
 *
 */
public class CharacterCount {
	HashMap<Character, Integer> countMap = new HashMap<>();
	
	public void countCharacter(String str) {
		for(int i = 0 ; i < str.length() ; i++) {
			Character ch = str.charAt(i);
			Integer count = countMap.get(ch);
			if(count  == null) {
				countMap.put(ch, 1);
			} else
				countMap.put(ch, count + 1);
		}
		
	}
	
	public static void main(String args[]) {
		CharacterCount cc = new CharacterCount();
		String str = "Hellohiareyou...";
		cc.countCharacter(str);
		cc.countMap.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
	}

}
