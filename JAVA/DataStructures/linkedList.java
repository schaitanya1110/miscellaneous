/* LinkedList implementation with initial functions to add nodes at front of the list ,back of the list and a particular index.*/
public class linkedList {

	class node {
		int value;
		node next = null;
		public node(int value) {
			this.value = value;

		}		
	}
	node head = null;
	node tail = null;
	node current = null;
	node last = null;
	int numElements = 0;
	//Add node at front of linked list
	public void addToFront(int value) {

		node newNode = new node(value);
		newNode.next = head;
		head = newNode;
		if (newNode.next == null) {
			tail = newNode;
		}
		this.numElements++;

	}
	// Add Node at back of the Linked List
	public void addToBack(int value) {
		node newNode = new node(value);	 
		tail.next = newNode;
		tail = newNode;
		if (head == null) {
			//if there is only 1 node in the linked list	
			head = newNode;
		}
		this.numElements++;

	}
	//Add Node at a particular index
	public void addAtIndex(int ind, int value) {
		int currcounter = 0;
		this.current = this.head;
		if (ind >= 0 & ind <= this.numElements) {
			if (ind == 0) {
				addToFront(value);
			}
			else if (ind == this.numElements){
				addToBack(value);		
			}
			else {
				node newNode = new node(value);	
				while (currcounter != ind - 1) {
					this.current = this.current.next;
					currcounter++;
				}

				newNode.next = this.current.next;
				this.current.next = newNode;
				this.numElements++;
			}
		}else {
			System.out.println("Insert index out of Range");
		}
	}

	//Find if a particular value is present in the Linked List 
	public boolean isinLL(int value) {
		if (value == this.head.value) {
			return true;

		}
		else{ 
			this.current = this.head;
			while(this.current.next != null) {
				if(this.current.value == value) {					
					return true;
				}else {
					this.current = this.current.next;
				}	
			}
		}
		return false;
	}

	//Delete Node from a particular Index
	public void delfromIndex(int ind) {

		int currcounter = 0;
		this.current =  this.head;
		if(ind > this.numElements) {
			System.out.println("No such Index available");
		}else if(ind == 0){
			this.head = this.head.next;
			this.numElements--;
		}else {
			while( currcounter != ind )
			{
				this.last = this.current;
				this.current =  this.current.next;
				currcounter++;
			}
			this.last.next = this.current.next; 
			this.numElements--;
		}

	}
	//Find Length of the list using Iterative approach
	public int lengthIter() {
		if (this.head == null){
			return 0;}else {
				int len = 1;
				this.current = this.head;
				while(this.current.next != null) {
					this.current = this.current.next;
					len++;
				}
				return len ;
			}
	}
	//Find length of Linked list using Recursive approach
	public static int lengthRecur(node tnode) {
		//Base Case
		if (tnode == null){
			return 0;}

		else { //Recursive Case
			return 1 +  lengthRecur(tnode.next);

		}		 

	}



	public static void main(String[] args) {
		int count = 0;
		linkedList newLL = new linkedList();		
		newLL.addToFront(3);
		newLL.addToFront(2);
		newLL.addToBack(4);
		newLL.addToBack(5);
		newLL.addToBack(6);
		newLL.addToBack(7);
		newLL.addAtIndex(0, 1);
		newLL.addAtIndex(0, 99);
		newLL.addAtIndex(5, 101);
		newLL.addAtIndex(5, 102);
		newLL.delfromIndex(5);
		newLL.delfromIndex(1);
		newLL.addAtIndex(5, 102);
		newLL.addAtIndex(0, 99);
		newLL.addToBack(76); 

		System.out.println("Total Number of Elements in Linked List is ");
		//Length of List - Class variable
		System.out.println(newLL.numElements);
		//Length of Linked List - Iterative approach
		System.out.println(newLL.lengthIter());
		//Length of Linked List - Recursive approach
		System.out.println(lengthRecur(newLL.head));

		if (newLL.numElements > 0){
			System.out.println("Printing Linked List elements - ");
			node tnode = newLL.head;
			while (count != newLL.numElements){
				if (count == 0) {			
					System.out.println(tnode.value);
				}else {
					tnode = tnode.next;
					System.out.println(tnode.value);	  
				}
				count++;
			}
		}
		System.out.println(newLL.isinLL(5)); 
		System.out.println(newLL.isinLL(9)); 
		System.out.println(newLL.isinLL(102)); 
	}

}
