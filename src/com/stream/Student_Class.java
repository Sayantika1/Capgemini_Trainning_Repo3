package com.stream;
import java.util.*;
public class Student_Class {

	public static void main(String[] args) {
		List<Student> students = List.of(
				new Student("A1",22,18),
				new Student("A3",33,21),
				new Student("C",88,26),
				new Student("A2",90,12)
				);
	//	List<Student> passed = students.stream()
	//			.filter(s-> s.marks>60)
	//			.toList();
	//	System.out.println(passed.size());
		
	/*	List<Student> eligible_to_vote = students.stream()
				.filter(s->s.age >=18) //not transform or mutate
				.filter(s->s.name.startsWith("A")) 
				.peek(s->System.out.println("Age greater than 18 is +"+s.name))
				.peek(s->s.setMarks(s.marks*2)) //mutating
				.map(s->new Student(s.name,s.marks,s.age)) //transform
				.peek(System.out::println)
				.toList();
	*/
	//	for(Student stud:eligible_to_vote)
	//	{
	//	System.out.println("Students eligible to vote "+ stud.name);
	//	}
		
		List<Student> passed = students.stream()
		        .sorted(Comparator
		                .comparingInt((Student s) -> s.marks)
		                .thenComparing(s -> s.name)
		        )
		        .toList();
		for(Student stud:passed)
		{
			System.out.println("Students eligible to vote "+ stud.name +" "+ stud.marks +" "+ stud.age);
		}

	}
	static class Student{
		String name;
		int marks;
		int age;
		
		Student(String name,int marks,int age)
		{
			this.name=name;
			this.marks=marks;
			this.age=age;
		}
		public void setMarks(int marks) {
		    this.marks = marks;
		}

	}

}


