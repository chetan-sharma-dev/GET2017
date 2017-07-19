package pfsession4;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class GetPermutation {
	/*
	 * creating common list instance
	 * */
	public List<String> permutaion_list;

	public GetPermutation() {
		
		permutaion_list = new ArrayList<String>();
	}

	/**
	 * @Method	permuteString(String input)
	 * permutes string permutations for given string
	 * @param	String 
	 * @return	type = List<String>, list of permuted strings 
	 * */
	public List<String> permuteString(String input) {
		try {
			/*
			 * if string length is >0 then continue or return IlligalArgumentException
			 * */
			if (input.length() > 0) {
				/*
				 * calling permute method which will return all permuted strings including repeated one
				 * */
				permutaion_list = permute("", input);
				/*
				 * removing repeated elements from ou
				 * */
				permutaion_list = new ArrayList<String>(new LinkedHashSet<String>(permutaion_list));
			} else
				throw new IllegalArgumentException(
						"here you passed illigal arguments");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		return permutaion_list;
	}
	
	/**
	 * @Method	permute(String temp, String input)
	 * permutes string permutations for given string 
	 * @param	two input Strings 
	 * @return	type = List<String>, list of permuted strings 
	 * */

	public List<String> permute(String temp, String input) {

		/*
		 * if input string is empty means temp is having our new string permutation so add it into list
		 * */
		if (input.equals("")) {
			permutaion_list.add(temp);
		}
		/*
		 * recursively do partition of string and call different combinations and append at last of removed element
		 * */
		for (int i = 0; i < input.length(); i++) {
			StringBuilder input1 = new StringBuilder(input);
			/*
			 * we are removing zero index char and adding it to temp
			 * */
			permute(temp + "" + String.valueOf(input.charAt(i)), input1
					.deleteCharAt(i).toString());

		}

		return permutaion_list;

	}

	
	
	
}
