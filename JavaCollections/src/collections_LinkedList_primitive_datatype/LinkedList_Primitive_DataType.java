package collections_LinkedList_primitive_datatype;

import java.util.Iterator;
import java.util.LinkedList;
//import java.util.LinkedList.Node;

public class LinkedList_Primitive_DataType 
{
	public static void main(String[] args) 
	{
		LinkedList<String> list = new LinkedList<String>();
		list.add("A");
		list.add("Z");
		list.add("X");
		list.add("B");
		list.add(3, "MMM");
		
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

/*
 . LinkedList is index based but not a good option to used index.
 . LinkedList maintains insertion order.
 . LInkedList is best suitable when the frequent operations include manupulation of the data beacuse
   there is no shifting of bits when data is manuplated in LinkedList.
 . LinkedList accepts duplicate values.
 * 
 * 
Internal Working:
=================

When LinkedList<String> list = new LinkedList<String>(); is called 
then an empty LinkedList will gets created.

In any doubly linked list there will always be two pointers first and last and both will be null 
initially as shown below 
first = last = null;

when add method as shown below is called:
public boolean add(E e) {
        linkLast(e);
        return true;
    }
linkLast(e); will get called as shown below:

void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
Initially first = last = null.
when first element is added new Node will get created as shown below:
final Node<E> newNode = new Node<>(l, e, null); where l is last node address, e is element null is for next.

Below is the class definition of Node

private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
 
 So now new node has element e, prev address as l and next address as null.
 now if last is null then first = newNode
 else if there are many elements already then 
 last = newNode
 last.prev.next = newNode or l.next = newNode
 
 Removing element:
 ================
 when list.removeLast() is called, below method gets called:
 
 Node l = last;
 E element l.item
 Node<E> prev = l.prev
 l.item=null
 l.prev=null
 last = prev
 if(last == null)
 first = null
 else
 last.next = null
 return element
 */

