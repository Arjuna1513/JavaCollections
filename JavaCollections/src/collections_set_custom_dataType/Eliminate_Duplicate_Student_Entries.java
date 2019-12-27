package collections_set_custom_dataType;

import java.util.ArrayList;
import java.util.HashSet;

import collections_set_custom_dataType.Student;

public class Eliminate_Duplicate_Student_Entries
{
	public static void main(String[] args) 
	{
		Student s1 = new Student(90, 16, "Arjuna");
		Student s2 = new Student(111, 19, "Dushyasana");
		Student s3 = new Student(60, 14, "Nakula");
		Student s4 = new Student(139, 29, "Sahadeva");
		Student s5 = new Student(22, 33, "Bhishma");
		Student s6 = new Student(22, 33, "Karna");
		Student s7 = new Student(60, 14, "Satya");
		
		HashSet<Student> al = new HashSet<Student>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);
		al.add(s6);
		al.add(s7);
		
		for(Student s : al)
		{
			System.out.println(s.id +"  "+s.name);
		}
	}
}
