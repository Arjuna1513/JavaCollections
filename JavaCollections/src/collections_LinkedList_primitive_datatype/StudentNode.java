package collections_LinkedList_primitive_datatype;

public class StudentNode<E>
{
	E item;
	public StudentNode<E> next = null;
	public StudentNode<E> prev = null;
	
	public StudentNode(StudentNode<E> prev,E item, StudentNode<E> next)
	{
		this.item = item;
		this.prev = prev;
		this.next = next;
	}
}

