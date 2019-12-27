package collections_set_custom_dataType;

public class Student 
{
	public int id;
	public int age;
	public String name;
	
	public Student(int id, int age, String name)
	{
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int hashCode()
	{
		return this.id;
	}
	
	@Override
	public boolean equals(Object o) 
	{
		Student s = (Student)o;
		if(this.id != s.id)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
