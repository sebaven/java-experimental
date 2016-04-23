package com.svenot.praxis;


/**********************************************************************************************************************
A string is titlecased when the first letter of each word is capitalized and the remaining letters are lower case. 
For instance, the string “programming PRAXIS” becomes “Programming Praxis” when titlecased.
Your task is to write a function that takes a string and returns it in titlecase. 
When you are finished, you are welcome to read or run a suggested solution, 
or to post your own solution or discuss the exercise in the comments below.
**********************************************************************************************************************/

public class TitleCase {

	public static void main(String[] args) {
		System.out.println(TitleCase.toTitleCase("programming PRAXIS"));
		System.out.println(TitleCase.toTitleCase("SOME TESTS"));
		System.out.println(TitleCase.toTitleCase("hello world"));
		System.out.println(TitleCase.toTitleCase("aTest Good"));
	}
	
	public static String toTitleCase(String input) {
		StringBuilder builder = new StringBuilder();
		char [] chars = input.toCharArray();
		boolean firstChar = true;
		for(char c: chars) {
			if(firstChar) {
				builder.append(Character.toUpperCase(c));
			} else {
				builder.append(Character.toLowerCase(c));
			}
			
			firstChar = Character.isSpaceChar(c);
		}
		return builder.toString();
	}
}
