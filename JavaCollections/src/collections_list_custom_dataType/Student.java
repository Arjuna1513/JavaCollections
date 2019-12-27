package collections_list_custom_dataType;

public class Student implements Comparable<Student>
{
	int id;
	int age;
	String name;
	
	public Student(int id, int age, String name)
	{
		this.id = id;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Student o) 
	{
		return this.id - o.id;
	}
	
	
}
