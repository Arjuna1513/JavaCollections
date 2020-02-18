/*
 * ArrayList is Index Based, we can retrieve/add/remove/set values based on index.
 * Internally ArrayList is implemented as Array.
 * The default size of the arrayList, if not mentioned would be 10.
 * When the requirement has frequent retrievals and rare additions/deletions then ArrayList is best bet.
 * When the requirement has frequent additions and deletions then ArrayList is not good since,
   every time element is added/deleted the shifting of bits takes place which results in performance 
   issues.
 * 
*/

package collections_list_primitive_dataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class ArrayListEx1 
{
	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>(100);
		list.add("A");
		list.add("B");
		list.add("C");
		list.add(1, "Index Based Insertion list1");
		list.remove(2);
		System.out.println(list.size());
//		System.out.println();
		
		ArrayList<String> list1 = new ArrayList<String>(3);
		list1.add("X");
		list1.add("Y");
		list1.add("Z");
		list1.add(1, "Index Based Insertion list2");
		
/*		for(String s : list)
		{
			System.out.println(s);
		}
		System.out.println("==================================");
		
		list.addAll(list1);
		for(String s : list)
		{
			System.out.print(s + "  ");
		}
		System.out.println();
		System.out.println(list.get(6));*/
		
/*		ArrayList<String> cln = (ArrayList)list.clone();//will return a clone of the ArrayList
		System.out.println(cln);
		System.out.println(list);
		System.out.println(cln == list);//false, b'coz cln and list are 2 different ArrayLists.
		
//		System.out.println(list.contains("XXX"));//false, b'coz list does not have String XXX.
//		System.out.println(list.containsAll(list1));//true, b'coz list has list1 in it.
//		System.out.println(list.removeAll(list1));//will remove the list1 from list
		System.out.println(list.remove(1)); //will return the removed element
//		System.out.println(list.size());
		System.out.println(list.);*/
//		list.remove(2);
		
		/*Iterator<String> itr = list.iterator();
		while(itr.hasNext())
		{
			if(itr.next().equals("A"))
			{
				itr.remove();
			}
		}*/
		
		/*for(String s : list)
		{
			System.out.println(s);
		}*/
		
		list.set(1, "Replaced B");
		ListIterator<String> itr1 = list.listIterator(list.size());
		while(itr1.hasPrevious())
		{
			System.out.println(itr1.previous());
		}
		/*int x = 100;
		int y = 200;
		int z = x > y ? 1 : 2;
		System.out.println(z);*/
	}
}
/*
 ArrayList is index based i.e. elements can be added or deleted based on index value.
 ArrayList does not maintain the insertion order.
 ArrayList accepts the duplicates.
 ArrayList values can be sorted.
 ArrayList is used when the frequent operations are storing and accessing.
 ArrayList not good for manupulating because when element is deleted all elements should be shifted
 towards left.
 * 
 * 
 ArrayList internally is implemented as array which grows dynamically.
 When we create ArrayList(5), then the paramterised constructor gets called as shown below:
 
 public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }
    
    now the Array of size 5 got created.
    
    else if when array is created ArrayList() without size then the below constructor gets called:
    
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    
    DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}
    The DEFAULTCAPACITY_EMPTY_ELEMENTDATA is pointing to empty list.
    
   In the above case where ArrayList is either given 0 or empty, when the first element is added 
   to the ArrayList then the size of the array would be changed to 10.
    
    Adding element to an arrayLIst:
    ===============================
    When an element is added to ArrayList below things takes place:
    
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
    
    When add(somevalue) is called, since 1 extra element is being added and the arrays are not
    dynamically growing(i.e. size cannot be changed in runtime) size should be incremented by 1
    size++,
    
    then ensureCapacityInternal is being called as shown below:
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
        
    Here, inside ensureCapacityInternal method, calculateCapacity method is called:
    
     private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
    
    Assume we have created an ArrayList() without size and we try to add the first element.
    =======================================================================================
    So Since this is the first element elementData will be pointing to DEFAULTCAPACITY_EMPTY_ELEMENTDATA,
    which means return Math.max(DEFAULT_CAPACITY, minCapacity); will get executed and value 10
    will be returned.
    
    Now ensureExplicitCapacity(calculateCapacity(elementData, minCapacity)); with value 10 will be called
      
      private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    
    In which it will check if 
    (minCapacity - elementData.length > 0)
            grow(minCapacity);
            
    Since 10 - 0 > 0
    grow(minCapacity); will be called.
    
     private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    
    Since oldCapacity is 0
    newCapacity = oldCapacity + (oldCapacity >> 1); will result in zero so,
    newCapacity - minCapacity i.e. 0 - 1 will be < 0
    so newCapacity = minCapacity;
    which means 
    newCapacity = 10
    
    then elementData = Arrays.copyOf(elementData, newCapacity); will get called which 
    created new Array with size 10 and copy the old elements.
    
    
    2.
     Assume we have created an ArrayList(5) and when we try to add the element
    =======================================================================================
    ArrayList internally is implemented as array which grows dynamically.
 When we create ArrayList(5), then the paramterised constructor gets called as shown below:
 
 public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }
    
    now the Array of size 5 got created.
    
    
    Adding element to an arrayLIst:
    ===============================
    When an element is added to ArrayList below things takes place:
    
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
    
    When add(somevalue) is called, since 1 extra element is being added and the arrays are not
    dynamically growing(i.e. size cannot be changed in runtime) size should be incremented by 1
    size++,
    
    then ensureCapacityInternal is being called as shown below:
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
        
    Here, inside ensureCapacityInternal method, calculateCapacity method is called:
    
     private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
    
    it will return minCapacity i.e. 5+1=6 because elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA
    
    Now ensureExplicitCapacity with value 6 is called.
    
     private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    
    Since 6 - 5 > 0 grow(6) will get called
        
     private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    
    Since oldCapacity is 5
    newCapacity = oldCapacity + (oldCapacity >> 1); will result in zero so,
    newCapacity - minCapacity 7 - 5 is not < 0
    so newCapacity = 7
    
  
    
    here newCapacity is calculated as shown below:
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    
    oldCapacity >> 1  ">>" shifts old bits to right 1 time.
    e.g.
    x = 8; //00000100
    x >> 1 //00000010 
    now x becomes 4 after right shifting by 1.

    if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
    if newCapacity >  MAX_ARRAY_SIZE(Integer.MAX_VALUE - 8) then 
    newCapacity = hugeCapacity(minCapacity); is called as shown below:
    
     private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
    the above will check if minCapacity > MAX_ARRAY_SIZE, if yes then return Integer.MAX_VALUE
    else return MAX_ARRAY_SIZE
    
    e.g. if minCapacity is 11 and arrayLength is 10 and the MAX array is 100 and when grow is called
    and if newCapacity value becomes 101 which is greater than MAX array size then 
    
    return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
            
    Then a new array of size newCapacity is created and the old array values are copied to it.
    
     
    
    
    
    
 */
