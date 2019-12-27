/*
 * Hashset will not accept duplicate entries.
 * HashSet will accept only one null value.
 * Hashset will internally implements hashMap to store and retrieve value.
 * Insertion order is not maintained in Hashset.
 * hashset elements cannot be sorted.
*/
package collections_set_primitive_dataType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Eliminate_Duplicates_Using_Set 
{
	public static void main(String[] args) 
	{
		Set<String> set = new HashSet<String>();
		set.add("Apple");
		set.add("Cat");
		set.add("Zebra");
		set.add("Ox");
		set.add("Eagle");
		set.add("Horse");
		set.add("Gun");
		set.add("Apple");
		set.add("Gun");
		set.add("null");
		set.add("null");
		
//		System.out.println(set.contains("Gun"));
//		System.out.println(set.equals(new HashSet<String>().add("Roja")));//returns true if 2 sets are equal else returns false.
//		set.removeIf(p -> (p.length() > 4));
		/*
		 * removeIf(filter) takes filter parameter, which is a predicate and the result of the predicate will be true or
		 * false, if true the element will be removed else it will not be removed.
		 * e.g. I will to delete the strings from the above set whose length is greater than 4.
		 * 
		 * removeIf(p->(p.length() > 4))
		 * it means, p.length() acts like for every String present in set and the result will be stored as boolean value 
		 * 
		*/
		System.out.println(set.remove("Gun"));
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("================================================================================================");
		Set<String> set1 = new HashSet<String>();
		set1.add("Apple");
		set1.add("Horse");
		set1.add("Zebra");
		set1.add("Ox");
		set1.add("Parrot");
		
		set.retainAll(set1);//if set has 1,2,3,4,5 and set2 has 1,2,3,8,9 then retainAll will keep only those
		//elements in set that are present in the set1 that is passed as parameter i.e. set has 1,2,3
		
		Iterator<String> itr1 = set.iterator();
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}
	}
}

/*
 When an HashSet constructor is called, in constructor an object for HashMap gets created as shown below:
 
 public HashSet() 
 {
    map = new HashMap<>();
 }
============================================================================================================================ 
 And since Map works like a key pairs we need an Value to associate with each key hence, a dummy value is associated with
 each key and dummi value declaration as shown below:
 
 private static final Object PRESENT = new Object();
 ============================================================================================================================ 
 Now when add(Object e) method is called, the implementation is shown below:
 
 public boolean add(E e)
 {
    return map.put(e, PRESENT)==null;
 }
 so, when add method is called, internally map.put(e,PRESENT) is called, and put method returns "null" if the key passed
 is not already present in the map and returns the hasCode of the old key if already present in map.
 
 so altogether if the key passed is not present in hashSet "null" is returned hence
 return map.put(e, PRESENT)==null; will become true and it will become false when element is already present in map.
 ============================================================================================================================
  
 */
