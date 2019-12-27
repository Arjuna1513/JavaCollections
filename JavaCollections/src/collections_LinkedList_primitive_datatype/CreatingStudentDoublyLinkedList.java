package collections_LinkedList_primitive_datatype;

import java.util.Collections;
import java.util.List;

public class CreatingStudentDoublyLinkedList<E>
{
	public StudentNode<E> first = null;
	public StudentNode<E> last = null;
	public int size = 0;
	
	public boolean addStudentNode(E e)
	{
		addLast(e);
		return true;
	}
	
	public boolean addLast(E e)
	{
		if(last == null)
		{
			StudentNode<E> newStudentNode = new StudentNode<E>(null, e, null);
			last = newStudentNode;
			first = newStudentNode;
		}
		else
		{
			StudentNode<E> newStudentNode = new StudentNode<E>(last, e, null);
			last.next = newStudentNode;
			last = newStudentNode;
		}
		
		return true;
	}
	
	public StudentNode<E> getElement(int index)
	{
		StudentNode<E> x = first;
		if(index < this.size)
		{
			for(int i=0; i<index-1; i++)
			{
			   x=x.next;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
		return x;
	}
	
	public StudentNode<E> remove(int index)
	{
		StudentNode<E> x = first;
		if(index == 0)
		{
			first = first.next;
			first.prev = null;
			return x;
		}
		else if(index == this.size-1)
		{
			x = last;
			last = last.prev;
			last.next = null;
			return x;
		}
		else if(index > 0 && index < this.size)
		{
			for(int i=0; i<index-1; i++)
			{
			   x=x.next;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
		StudentNode<E> y = x.next;
		x.next = x.next.next;
		x.next.prev = x;
//		y.item = null;
		
		return y;
	}
	
	public static void main(String[] args) 
	{
		
		
		CreatingStudentDoublyLinkedList<LinkedListStudent> dll = new CreatingStudentDoublyLinkedList<LinkedListStudent>();
		
		dll.addStudentNode(new LinkedListStudent(100, 20, "A"));
		dll.addStudentNode(new LinkedListStudent(90, 23, "Z"));
		dll.addStudentNode(new LinkedListStudent(110, 23, "C"));
		dll.addStudentNode(new LinkedListStudent(40, 25, "X"));
		
		
		StudentNode<LinkedListStudent> ptr = dll.first;
		while(ptr!=null)
		{
			dll.size++;
			System.out.println(ptr.item.id);
			ptr = ptr.next;
		}
		
//		System.out.println(dll.getElement(0).next.item.id);
		System.out.println("Removed item := "+ dll.remove(3).item.id);
		System.out.println("===================================================");
		
		StudentNode<LinkedListStudent> ptr1 = dll.first;
		while(ptr1!=null)
		{
//			dll.size++;
			System.out.println(ptr1.item.id);
			ptr1 = ptr1.next;
		}
	}
	
	/*public CreatingStudentDoublyLinkedList<LinkedListStudent> sort()
	{	
		for(int i=0; i < this.size; i++)
		{
			System.out.println("mmmmmmmmm");
			StudentNode<LinkedListStudent> ptr = (StudentNode<LinkedListStudent>) this.first;
			for(int j=0; j<this.size; j++)
			{
				while(ptr!=null)
				{
					if(ptr.next.item.id > ptr.next.next.item.id)
					{
						StudentNode<LinkedListStudent> e = ptr.next;
						ptr.next = ptr.next.next;
						ptr.next.next = e;
					}
				}
			}
		}
	  return (CreatingStudentDoublyLinkedList<LinkedListStudent>) this;	
	}*/
}
