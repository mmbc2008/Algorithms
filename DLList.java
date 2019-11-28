

class DLList {
  class Node {
    // Each node object has these three fields
    private Object element;
    private Node previous;
    private Node next;

    // Constructor: Creates a Node object with element = e, previous = p and next = n
    Node(Object e, Node p, Node n) {
      element = e;
      previous = p;
      next = n;
    }

    // This function gets Object e as input and sets e as the element of the Node
    public void setElement(Object e) {
      element = e;
    }

    // This function returns the element variable of the Node
    public Object getElement() {
      return element;
    }

    // This function gets Node n as input and sets the next variable of the current Node object as n.
    public void setNext(Node n) {
      next = n;
    }

    // This function returns the next Node
    public Node getNext() {
      return next;
    }

    // This function gets Node p as input and sets the previous variable of the current Node object as p.
    public void setPrevious(Node p) {
      previous = p;
    }

    // This function returns the previous Node
    public Node getPrevious() {
      return previous;
    }
  }

  // Each object in DLList has one field head, which points to the starting Node of DLList.
  private Node head;
  // Each object in DLList has one field tail, which points to the final Node of DLList.
  private Node tail;

  /**
   * Constructor: initialises the head and tail fields as null
   */
  public DLList() {
    head = null;
    tail = null;
  }

  /**
   * @return The element in the head Node of the DLL
   */
  public Object getHead() {
    return head.getElement();
  }

  /**
   * @return The element in the tail Node of the DLL
   */
  public Object getTail() {
    return tail.getElement();
  }
  /**
   * Adds element e in a new Node to the head of the list.
   *
   * @param e
   *     The element to add.
   */
  public void addFirst(Object e) {
    // create a new node
    head = new Node(e, null, head);
    tail = new Node(e, head , null);
    Node temp = head;
    
    if(head != null) {
    	head.previous = temp;
    }
    head = temp;
    if(tail == null) {
    	tail = temp;
    }

  }

  /**
   * Remove the first Node in the list and return its element.
   *
   * @return The element of the head Node. If the list is empty, this method returns null.
   */
  public Object removeFirst() {
    if(head == null)
    {
      return null;
    }
    Node temp = head;
    head = head.getNext();
    
    
    return temp.getElement();
  }

  /**
   * Adds element e in a new Node to the tail of the list.
   *
   * @param e
   *     The element to add.
   */
  public void addLast(Object e) {
   
    if(head == null)
    {
      addFirst(e);
    }
    else
    {
       Node temp = new Node(e, tail, null);
       Node tail = head;
        while (tail.getNext() != null) {
        tail = tail.getNext();
      }
       tail.setNext(temp);
       tail = temp;
    }
  }

  /**
   * Remove the last Node in the list and return its element.
   *
   * @return The element of the tail Node. If the list is empty, this method returns null.
   */
  public Object removeLast() {
    if(head == null)
    {
      return null;
    }
    if(head.getNext() == null)
    {
      return removeFirst();
    }
    
    Node result = head;
    Node prev = head;
    
    while (result.getNext() != null)
    {
      prev = result;
      result = result.getNext();
    }
    
    prev.setNext(null);
    return result.getElement();
  }

  /**
   * @return the number of Nodes in the list
   */
  public int size() {
  Node temp = head;
  int size = 0;
  while (temp != null) {
	  size++;
	  temp = temp.getNext();
  }
   return size;
  }

  /**
   * Adds element e in a new Node which is inserted at position pos.
   * The list is zero indexed, so the first element in the list corresponds to position 0.
   * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
   * If there is no Node in position pos, this method adds it to the last position.
   *
   * @param pos
   *     The position to insert the element at.
   * @param e
   *     The element to add.
   */
  public void addAtPosition(int pos, Object e) {
    Node node = new Node(e, head, null);
    
    if(this.head == null) {
    	if(pos != 0)
    	{
    		return;
    	}
    	else
    	{
    		this.head = node;
    	}
    }
    
    if(head != null && pos == 0)
    {
    	node.next = this.head;
    	this.head = node;
    	return;
    }
    
    Node current = this.head;
    Node prev = null;
    int i = 0;
    
    while (i < pos) {
    	prev = current;
    	current = current.next;
    	
    	if(current == null) {
        	break;
        }
    	
    	i++;
    }
    
    node.next = current;
    prev.next = node;
    
    
    
	  
	  
    
    
  }

  /**
   * Remove Node at position pos and return its element.
   * The list is zero indexed, so the first element in the list corresponds to position 0.
   * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
   *
   * @param pos
   *     The position to remove the Node from.
   * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
   */
  public Object removeFromPosition(int pos) {
    if(pos == 0)
    {
      return removeFirst();
    }
    else if(pos < 0 && pos >= size())
    {
      return null;
    }
    
    
    	 Node temp = head;
    	 Node prev = null;
    	 
      while (pos > 0 &&temp != null)
      {
    	  prev = temp;
    	  temp = temp.getNext();
    	  pos = pos - 1;
      }
      if(temp == null)
      {
      	return null;
      }
      
      prev.setNext(temp.getNext());
      return temp.getElement();
      
    
    
  }

  /**
   * @return A new DLL that contains the elements of the current one in reversed order.
   */
  public DLList reverse() {
    int size = 0;
    
    Node current = this.head;
    
    while (current != null) {
    	size++;
    	current = current.getNext();
    	
    }
    
    Object[] e = new Object[size];
    
    current = this.head;
    int index = 0;
    
    while (head!= null) {
    	e[index++] = current.getElement();
    	current = current.getNext();
    	
    }
    DLList reversed = new DLList();
    
    for (index = size - 1; index >= 0; index--)
    	reversed.addAtPosition(index, e[index]);
    	System.out.println(e[index]);
    	return reversed;
  }

    
}