package collections_LinkedList_primitive_datatype;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList_Primitive_DataType 
{
	public static void main(String[] args) 
	{
		LinkedList<String> list = new LinkedList<String>();
		list.add("A");
		list.add("Z");
		list.add("X");
		list.add("B");
		
		list.addFirst("M");
		list.addLast("XXX");
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		list.removeFirst();
		list.removeLast();
		list.get(9);
		
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}
