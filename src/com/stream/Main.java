package com.stream;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
	//	List<Integer> even = new ArrayList<>();
	//	for(Integer n:list)
	//	{
	//		if(n%2==0)
	//		{
	//			even.add(n);
	//		}
	//	}
		
		List<Integer> even = list.stream() //source
							.filter(n -> n % 2 == 0) //intermediate
							.map(n->n*2) //intermediate
							.toList(); //collect or terminal
		
		System.out.println(even);
// Collection > Stream > Filter > Transform > Collect > Result
		
/*characteristics of stream
 * ->stream doesnot store any data
 * ->sources can be collections , arrays, files, generated functions
 * ->stream is functional in nature and then it uses lambda expressions , functional interfaces,method reference
 * ->stream operations are lazy
 * -> nothing happens untill u call terminal operations , execution  start only after calling this functions toList(),count(),forEach(),collect() 
 */// SOURCE -> INTERMEDIATE OPERATIONS -> TERMINAL OPERATION */
	}

}
