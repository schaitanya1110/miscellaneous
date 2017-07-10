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
	int numElements = 0;

	public void addToFront(int value) {

		node newNode = new node(value);
		newNode.next = head;
		head = newNode;
		if (newNode.next == null) {
			tail = newNode;
		}
		this.numElements++;
		 
	}

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
		System.out.println("Total Number of Elements in Linked List is ");
		System.out.println(newLL.numElements);
		node tnode = newLL.head;
		System.out.println("Below are the elements ");
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

}
