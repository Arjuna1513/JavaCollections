package collections_Map.primitiveType;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

public class LinkedHashMapEx1 
{
	public static void main(String[] args) 
	{
		LinkedHashMap<String, String> hMap = new LinkedHashMap<String, String>();
		hMap.put("A", "Apple");
		hMap.put("B", "Ball");
		hMap.put("C", "Cat");
		hMap.put("C", "CATT");
		hMap.put(null, "Cat");
		hMap.put(null, "CATTTT");
		
		System.out.println(hMap.get("A"));
		System.out.println(hMap.get("XXX"));
		
		System.out.println(hMap.containsKey("A"));
		System.out.println(hMap.containsValue("Apple"));
		
		System.out.println(hMap.remove("A"));
		
		System.out.println(hMap.get("A"));
		
		Set<Entry<String,String>> e = hMap.entrySet();
		System.out.println(e);
		
		for(Entry<String, String> etr : e)
		{
			System.out.println(etr.getKey());
			System.out.println(etr.getValue());
		}
		
		/*Set<String> ks = hMap.keySet();
		Collection<String> vs = hMap.values();
		
		for(String s : ks)
		{
			System.out.println(s);
		}
		
		for(String s : vs)
		{
			System.out.println(s);
		}*/
	}
}


/*
 Implementation is similar to HashMap except that Every Entry set will have below fields:
 
 key
 value
 hash
 next
 before
 after
 
 and hence because of this we are able to retrieve the elements in the insertion order.
 */
