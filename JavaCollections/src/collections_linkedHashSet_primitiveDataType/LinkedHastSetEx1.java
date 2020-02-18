package collections_linkedHashSet_primitiveDataType;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LinkedHastSetEx1 
{
	public static void main(String[] args) 
	{
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.add("A");
		
		
	}
}
/*
 . LinkedHashSet maintains insertion order.
 
 There are 2 things to consider in LinkedHashMap i.e.
 . initialCapacity
 . loadFactor.
 
 . initailCapacity : it is the capacity of the LinkedHashMap i.e. the number of elements it can store.
 . loadFactor : defines until what measure(or percentage) of the Hash table is allowed to get full
   before it's size is automatically increased.
   
There are 4 constructors in LinkedHashset
==========================================
    // Constructor 1
     public LinkedHashSet (int initialCapacity , float loadFactor)
    {
        super(initialCapacity , loadFactor , true); 
    }
    LinkedHashSet extends HashSet hence super is used to initialize LinkedHashSet constructor.
    
	Note : If initialCapacity or loadFactor parameter value is missing during LinkedHashSet 
	object creation , then default value of initialCapacity or loadFactor is used.
	Default value for initialCapacity : 16    ,
	Default value for loadFactor      : 0.75f
	
    // Constructor 2
     public LinkedHashSet (int initialCapacity)
    {
        super(initialCapacity , 0.75f , true); 
    }
    In the above since loadFactor is not received, we are passing the default value of loadFactor.
    
    // Constructor 3
     public LinkedHashSet ()
    {
        super(16 , 0.75f , true); 
    }
    In the above since capacity and loadFactor is not received we are passing their default values.
    
    // Constructor 4
     public LinkedHashSet (Collection c)
    {
        super(Math.max(2*c.size() ,11) , 0.75f , true); 
    }
    
    NOTE:In every constructor we are passing a boolean value true, which has no exact purpose,
    except to distinguish the other constructors which accepts initailCapacity and loadFactor.
    i.e. when we call an HashSet constructor directly even it accepts capacity and load, so to
    differentiate HashSet constructors which accepts capacity and loadFactor and also creates
    LinkedHashSet we needed some technique, so dummy boolean value is used to accomplish that.
	
	So, when super(10,0.75f, true) is called, below constructor of HashSet gets called
	HashSet(int initialCapacity, float loadFactor, boolean dummy) 
	{
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }

	new LinkedHashMap<>(initialCapacity, loadFactor); constructor gets called when u check the
	code of constructor it looks as shown below:
	
	 public LinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        accessOrder = false;
    }
    
    Here is the trick, in the above constructor again super(initialCapacity, loadFactor) is called,
    because LinkedHashMap extends HashMap hence Constructor of HashMap gets called.
    
    Below is the HashMap constructor definition:
    ============================================
    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

	lhs.add("A")
	when the above method is called put method of HashMap get's called, becuase LinkedHashSet
	is a subclass of HashSet and in HashSet HashMap is created
	 public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
	 
	 And since put is a method of HashMap hence put method of HashMap gets called as shown below:
	  public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
=================================================================================================    
    And below is the implementation for hash(key) method:
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    Here "^" is a bitwise operator which returns 1 if the corresponding bits of two operands are 
    different else it will return 0.
    e.g.
    
      String str1 = "1010100101";
      String str2 = "1110000101";
      StringBuffer sb = new StringBuffer();

      for (int i = 0; i < str1.length(); i++) 
      {
         sb.append(str1.charAt(i)^str2.charAt(i));
      }
    
	o/p : 0100100000
	
	Now with the value of hash(key) below method gets called:
	 public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
==================================================================================================    
  putVal method adds the value to the Map and returns the added value.
    
	
*/