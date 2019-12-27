package collections_LinkedList_primitive_datatype;


public class LinkedListStudent implements Comparable<LinkedListStudent>
{
	int id;
	int age;
	String name;
	
	public LinkedListStudent(int id, int age, String name)
	{
		this.id = id;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(LinkedListStudent o) 
	{
		return this.id - o.id;
	}
}
