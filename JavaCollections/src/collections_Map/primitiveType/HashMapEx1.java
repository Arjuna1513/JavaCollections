package collections_Map.primitiveType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx1 
{
	public static void main(String[] args) 
	{
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("A", "Apple");
		hMap.put("B", "Ball");
		hMap.put("C", "Cat");
		
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
		
		Set<String> ks = hMap.keySet();
		Collection<String> vs = hMap.values();
		
		for(String s : ks)
		{
			System.out.println(s);
		}
		
		for(String s : vs)
		{
			System.out.println(s);
		}
	}
}

/*
Below are the the default values defined for the HashMap:
=========================================================
 
 static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
   
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
    
  static final int MAXIMUM_CAPACITY = 1 << 30;
   
     * The load factor used when none specified in constructor.
      static final float DEFAULT_LOAD_FACTOR = 0.75f;
      
  static final int TREEIFY_THRESHOLD = 8;
  static final int UNTREEIFY_THRESHOLD = 6;
  static final int MIN_TREEIFY_CAPACITY = 64;
  
  When the number of Nodes in any bucket reaches 8 then treeify method gets called which again
  will check for the table size being equal to MIN_TREEIFY_CAPACITY whose value is 64
  and if the size of the table is less than 64 then instead of changing the list to Tree
  it will call resize method and increases the size.
  
  But when treeify method is called and the size of the tab equals to MIN_TREEIFY_CAPACITY(64) then 
  the list present in the bucket is changed to Tree.
  
  static final int UNTREEIFY_THRESHOLD = 6; : When the size of the Tree in Bucket reduces to less than
  6 the again Tree is converted to list.
  
  Constructors:
  =============
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
    
     public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    
     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
     * (16) and the default load factor (0.75).
     
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

Adding value in to an Map:
=========================
When a put(key, value) is called below method gets called:
public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
    
    Again hash(Key) gets called as howb below:
    
     static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    The above method calculates the hash(index) value in the table(array of linked lists) so that
    the new node can be entered or placed in to that bucket/index of the map.
    
    Here hash value itself is the index value.
    
    How internally put works:
    =========================
    When put(key, value) is called internally hash(key) method will get called and hash function 
    will generate the hash value and this process is known as hashing.
    
    Here hash(key) will apply some bitwise logic on hashCode of the object and gives us the hash
    value which itself is the index value.
    
   say suppose put("A", "Apple") is added, then hashCode is called say suppose hashcode of key 
   "A" is 10001001 now hash value will be generated and say suppose hash value is 2.
   
   Here 2 is also called as bucket value.
   
   Now at the index 2, a new node will be created which is an Map.Entry<K, V> object and the Entry
   object will have HashCode, key, value, next-->Map.Entry<K, V>.
   
   If first variable reference is null i.e. the list at given index is null, then the
   newNode will be added there and first will point to newly added node.
   
   Else if already there was an element at index 2, now hashCode of first node is compared with that
   of newNode and they are equal then the value of the keys are compared and if they are same
   then new first will be replaced with new Node and first will point to newly added Node.
   
   Now if the hashCode of new Node is equal to that of first and the keys are not same, then the node 
   referenced by the next of first Node is considered and the hashCode and keys are compared and 
   they are different now again next reference of current node is checked and if it is null then
   new Node is inserted there else again the story continues.
   
   Note:
   While adding the new Node,check for the size of the list is done and if the size crossed 8 then
   treeify method will be called which again checks the table length and if the table length is 
   less than 64 then the resize of the table takes place and if table size is already 64 
   then the list present at the given bucket or index will be converted to Tree.
   
   Similary when ever the size of the list becomes less than 6 after removing elements then the Tree
   will be converted to list again.
   
   What is collision in HashMap?
   =============================
	 Since the internal array of HashMap is of fixed size, and if you keep storing 
	 objects, at some point of time hash function will return same bucket location for 
	 two different keys, this is called collision in HashMap. In this case, a linked list is 
	 formed at that bucket location and a new entry is stored as next node.

	If we try to retrieve an object from this linked list, we need an extra check to search correct 
	value, this is done by equals() method. Since each node contains an entry, HashMap keeps comparing 
	entry's key object with the passed key using equals() and when it return true, Map returns the 
	corresponding value.


   
   HashCode and equals Contract:
   =============================
   As per hashCode and equals contract, for the two Nodes(Keys) to be equal the hashcodes of both Nodes
   must be equal and then the keys of both nodes should be equal.
   
   But however, we cannot say that 2 Nodes are equal just because they have same hashCodes, because 2 
   different Nodes can have same hashCodes but their keys are different.
   
   How get(key) works internally:
   ==============================
   When we invoke method map.get(key) then again the hash(key) is generated and now we have
   hash/index/bucket value, now at the given index the hashCode of the given key is compared
   with that of the first Node and if they are same then their key values are compared
   and if they are same then the value associated with that of key is returned.
   
   If the key doesn't match with first then the same procedure will be followed for
   next elements and if the key match doesn't found then null value is returned.
   
   
   
  
  
*/