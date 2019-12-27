package collections_LinkedList_primitive_datatype;

public class Node<E> 
{
	E item;
	public Node<E> next = null;
	public Node<E> prev = null;
	
	public Node(Node<E> prev,E item, Node<E> next)
	{
		this.item = item;
		this.prev = prev;
		this.next = next;
	}
}
