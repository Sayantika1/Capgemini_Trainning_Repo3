package com.stream;

import java.util.*;

import com.stream.Student2.Student;

public class GetName {
	
	
	public static void main(String[] args) {
		List<Student> students = List.of(
				new Student(1,20,"Ram"),
				new Student(2,18,"Hari"),
				new Student(2,25,"Sita")
				);
		//1 .->get names of all students
		students.stream()
		.forEach(s->System.out.println(s.getname()));
		//2 .->count Adults
		long count= students.stream()
				.filter(s->s.getage()>18)
				.count();
		System.out.println("No of adults are " + count);
		
		// 3 -> Double age of adults (18–40) and collect as Student object
		List<Student> doubledAge = students.stream()
		        .filter(s -> s.getage() > 18 && s.getage() < 40)
		        .map(s -> new Student(s.getid(), s.getage() * 2, s.getname()))
		        .toList();

		doubledAge.forEach(s ->
		        System.out.println(s.getname() + " (" + s.getage() + ")")
		);


		// 4 -> Find first minor student (age < 18)
		Optional<Student> firstMinor = students.stream()
		        .filter(s -> s.getage() < 18)
		        .findFirst();

		firstMinor.ifPresent(s ->
		        System.out.println("First minor: " + s.getname())
		);


		// 5 -> Sum of ages of only adults
		int sumAge = students.stream()
		        .filter(s -> s.getage() >= 18)
		        .mapToInt(Student::getage)
		        .sum();

		System.out.println("Sum of adult ages: " + sumAge);


		// 6 -> Check if all students are adults
		boolean allAdults = students.stream()
		        .allMatch(s -> s.getage() >= 18);

		System.out.println("Are all students adults? " + allAdults);

		

	}
	static class Student
	{
		int id;
		int age;
		String name;
		
		public Student(int id,int age , String name)
		{
			this.id=id;
			this.age=age;
			this.name=name;
		}
		
		public int getid()
		{
			return id;
		}
		public String getname()
		{
			return name;
		}
		
		public int getage()
		{
			return age; 
		}
	}
	

}
