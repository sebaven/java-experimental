package com.svenot.praxis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**********************************************************************************************************************
an interview question from Google:

Given a list of words, find the maximum value of the product of the lengths of two words from the list, 
subject to the constraint that the two words cannot share any letters. 
For instance, given the words ABCW, BAZ, FOO, BAR, XTFN, and ABCDEF, 
the pair FOO BAR has a product of 9, the pair BAZ XFTN has a product of 12, and the pair ABCW XTFN has a product of 16,
which is the maximum. Note that the pair ABCW ABCDEF doesn’t work because the two words share three letters.
**********************************************************************************************************************/
public class GoogleInterviewQuestion {
	
	private static String [] WORDS_BAG = { "ABCW", "BAZ", "FOO", "BAR", "XTFN", "ABCDEF" };

	public static void main(String[] args) {
		int maxProduct = 0;
		for(String word : WORDS_BAG) {
			int product = computeHighestProduct(word);
			if(product > maxProduct) {
				maxProduct = product;
			}
		}
		
		System.out.println("maximum product:" + maxProduct);
	}
	
	public static int computeHighestProduct(String value) {
		int product = 0;
		for(String word : WORDS_BAG) {
			List<String> a = convert(value.toCharArray());
			List<String> b = convert(word.toCharArray());

			if(Collections.disjoint(a, b)) {
				int current = value.length() *  word.length();
				System.out.println(String.format("Product of value %s and %s is %s", word, value, current));
				if(current > product) {
					product = current;
				}
			}
		}
		return product;
	}
	
	public static List<String> convert(char[] array){
		ArrayList<String> list = new ArrayList<>();
    	for(char c : array) {
    		list.add(String.valueOf(c));
    	}
		return list;
	}

}
