package collections_LinkedList_primitive_datatype;

public class CreatingDoublyLinkedList<E>
{
	public Node<E> first = null;
	public Node<E> last = null;
	
	public boolean addNode(E e)
	{
		addLast(e);
		return true;
	}
	
	public boolean addLast(E e)
	{
		if(last == null)
		{
			Node<E> newNode = new Node<E>(null, e, null);
			last = newNode;
			first = newNode;
		}
		else
		{
			Node<E> newNode = new Node<E>(last, e, null);
			last.next = newNode;
			last = newNode;
		}
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		CreatingDoublyLinkedList dll = new CreatingDoublyLinkedList();
		dll.addNode("A");
		dll.addNode("B");
		dll.addNode("C");
		Node ptr = dll.first;
		while(ptr!=null)
		{
			System.out.println(ptr.item);
			ptr = ptr.next;
		}
	}
}
