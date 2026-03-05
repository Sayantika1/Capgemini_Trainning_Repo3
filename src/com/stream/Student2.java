package com.stream;
import java.util.*;
public class Student2 {

	public static void main(String[] args) {
		List<Student> students = List.of(
				new Student(3,"A1",18),
				new Student(2,"A3",21),
				new Student(8,"C",26),
				new Student(1,"A2",12)
				);
		//toList
		List<Student> adults=students.stream()
				.filter(s->s.getage()>10)
				.toList();
		System.out.println(adults);
		
		//forEach
		students.stream()
				.forEach(s->System.out.println(s.getage()>18));
		//count 
		long count= students.stream()
				.filter(s->s.getage()>18)
				.count();
		System.out.println(count);
		
		//findFirst
		Optional<Student> first=students.stream()
				.filter(s->s.getage()>18)
				.findFirst();
		
		//anyMatch()
		boolean anyMinor=students.stream().anyMatch(s->s.getage()<18);
		
		//allMatch()
		boolean allAdults=students.stream().anyMatch(s->s.getage()>18);
		
		//noneMatch()
		boolean noneSenior=students.stream()
				.noneMatch(s->s.getage()>60);
		
		//reduce
		int totalAge=students.stream()
				//.map(Student ::getage)
				.map(s->s.getage())
				//.reduce(0,Integer::sum)    //(a,b) -> a+b
				.reduce(0, (a,b)->a+b);
		
	}
	static class Student{
		int id;
		String name;
		
		int age;
		
		Student(int id,String name,int age)
		{
			this.id=id;
			this.name=name;
			
			this.age=age;
		}
		public int getid(){
			return id;
		}
		public int getage() {
		    return age;
		}
		public String getname() {
		    return name;
		}

	}

}
//COMMON INTERMEDIATE OPERATIONS
	//filter() -remove elements
	//map() - transform elements
	//sorted() -sort element
	//distinct() -remove duplicates
	//limit()  - take first N
	//skip() -skip first N
	//peek() - debug /log


//COMMON TERMINAL OPERATIONS
	//toList(), collect - gather results
	// forEach() - iterate
	// count() - count elements
	// findFirst() - get first
	// anyMatch(), allMatch(), nonMatch - condition check
	// reduce() - aggregation
