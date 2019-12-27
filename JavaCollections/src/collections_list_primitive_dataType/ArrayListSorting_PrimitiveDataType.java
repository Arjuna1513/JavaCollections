package collections_list_primitive_dataType;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorting_PrimitiveDataType 
{
	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("Zebra");
		list.add("Cab");
		list.add("Deer");
		list.add("Bananna");
		
		System.out.println(list);
		Collections.sort(list);
		for(String s : list)
		{
			System.out.println(s);
		}
	}
}
