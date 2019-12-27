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
    
    here the size of the array would be 10.
    
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
    
    when the above method is called it checks the max values among DEfaultCapacity(i.e. 10) and the new
    size of the array i.e. size+1(minCapacity) and returns the same, using the returned value 
    ensureExplicitCapacity method is called as shown below:
    
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    
    Say suppose minCapacity is 6 and the array was created with default size i.e.
    elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA now minCapacity = 6 and elementData.length = 10.
    then calculateCapacity will return the max value among 6, 10, since 10 is greater, the same is returned
    and the same is passed to ensureExplicitCapacity method where in it checks 
    if (minCapacity - elementData.length > 0)
            grow(minCapacity);
            
    i.e. if minCapacity is greater than the size of the array it will call grow method as shown below:
    
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
    
    here newCapacity is calculated as shown below:
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    
    oldCapacity >> 1  ">>" shifts old bits to right 1 time.
    e.g.
    x = 8; //00000100
    x >> 1 //00000010 
    now x becomes 4 after right shifting by 1.
    
    if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
    Checks if still newCapacity < minCapacity, if yes
    then   newCapacity = minCapacity;
    
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
