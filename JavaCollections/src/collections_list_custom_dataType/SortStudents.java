package collections_list_custom_dataType;

import java.util.ArrayList;
import java.util.Collections;

public class SortStudents 
{
	public static void main(String[] args) 
	{
		Student s1 = new Student(90, 16, "Arjuna");
		Student s2 = new Student(111, 19, "Dushyasana");
		Student s3 = new Student(60, 14, "Nakula");
		Student s4 = new Student(139, 29, "Sahadeva");
		Student s5 = new Student(22, 33, "Bhishma");
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);
		
		Collections.sort(al);
		
		for(Student s : al)
		{
			System.out.println(s.id +" | "+s.age+" | " + s.name);
		}
	}
}
