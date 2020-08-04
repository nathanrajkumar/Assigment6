package com.coderscampus.arraylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomArrayListApplication {
	public static void main(String[] args) {
		numbersTest();
		//stringTest();
		
	}

	private static void stringTest() {
		CustomList<String> strings = new CustomArrayList<>();
		strings.add("ONE");
		strings.add("TWO");
		strings.add("THREE");
		strings.add("FOUR");
		strings.add("FIVE");
		strings.add("SIX");
		strings.add("SEVEN");
		strings.add("EIGHT");
		strings.add("NINE");
		strings.add("TEN");
		strings.add("ELEVEN");
		strings.add("TWELVE");
		strings.add("THIRTEEN");
		strings.getSize();
		strings.get(10);
		
		// then you should validate that all the elements you've inserted actually exist in your data structure
		for (int i=0; i<strings.getSize(); i++) {
		    System.out.println(strings.get(i));
		}
	}

	private static void numbersTest() {
		Date start = new Date();
		List<Integer> regularArrayList = new ArrayList<>();
		for(int i=0; i<=50000000; i++) {
			regularArrayList.add(i);
		}
		Date end = new Date();
		
		System.out.println("It took " + (end.getTime() - start.getTime()) + " milliseconds to complete");
		
		CustomList<Integer> numbers = new CustomArrayList<>();
		
		start = new Date();
		for(int i=0; i<=50000000; i++) {
			numbers.add(i);
		}
		end = new Date();
		System.out.println("It took " + (end.getTime() - start.getTime()) + " milliseconds to complete");
		
//		// then you should validate that all the elements you've inserted actually exist in your data structure
//		for (int i=0; i<numbers.getSize(); i++) {
//		    System.out.println(numbers.get(i));
//		}
//		

	}
}
