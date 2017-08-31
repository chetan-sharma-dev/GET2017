package com.metacube.concordanceofcharacter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.metacube.queue.MyQueue;
/**
 * @class 
 * class that gives concordance of characters 
 * */
public class Concordance {
	Map<Character,List<Integer>> concordanceMap;
	
	public Concordance() {
		concordanceMap=new HashMap<Character, List<Integer>>();
	}
	
	/**
	 * @method addString()
	 * method to add string concordance in hashMap
	 * */
	public void addString(String userInputString){
		//checking for null conditions
		if(userInputString!=null){
			int indexNoOfCharacter=0;
			for(int index=0;index<userInputString.length();index++){
				/*
				 * checking whether the current index char is present in map or not
				 * if yes, than storing it's index ,ignoring other elements in map
				 * else, checking whether current index character in given string is alphabet or not
				 * if it is alphabet then doing it's entry in map
				 */
				
				if(concordanceMap.containsKey(userInputString.charAt(index))){
					concordanceMap.get(userInputString.charAt(index)).add(indexNoOfCharacter++);
				}else{
					
					Character charAtGivenIndex=userInputString.charAt(index);
					if(Character.isAlphabetic(charAtGivenIndex))
						{
							List<Integer> list=new ArrayList<Integer>();
							list.add(indexNoOfCharacter++);
							concordanceMap.put(userInputString.charAt(index),list);}
						}
			}
		}
	
	}
	/**
	 * @method getConcodanceOfCharaters
	 * method return concordance of characters
	 * */
	public String getConcodanceOfCharaters(){
		/**
		 * iterating map if it's size >0
		 * else returning Not Found Error message
		 * */
		
		String concordanceOutput;
		concordanceOutput="{ ";
		List<Character> listOfKeys=new ArrayList<Character>(concordanceMap.keySet());
		if(listOfKeys.size()>0){
			Iterator<Character> iterator=listOfKeys.iterator();
			while(iterator.hasNext()){
				Character key=iterator.next();
				concordanceOutput+=key+"="+concordanceMap.get(key).toString()+",";
			}
			concordanceOutput+="}";
		}else{
			concordanceOutput="No Concordence Entry Found";
		}
		return concordanceOutput;				
	}
	
	
	public static void main(String[] args) {
		Concordance concordanceObject=new Concordance();
		concordanceObject.addString(null);
		System.out.println(concordanceObject.getConcodanceOfCharaters());
	}
}
