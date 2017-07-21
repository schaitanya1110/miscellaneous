

import java.util.Iterator;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

	public static void insertSorted(LinkedList<Integer> list, int value) {
//Check if List is not equal to Null		 
		if (list != null){
			int head = list.element();
			if (head >= value) {
				list.addFirst(value);
			}else if(value >= list.getLast()){
				list.addLast(value);
			}else {
				int count = 0;
				Iterator<Integer> x = list.listIterator();
				while(x.hasNext()) {				
					if (x.next() >= value) {
						list.add(count, value);
						break;
					}else if(x.next() < value) {
						count++;
					}

				}
			}
		}  
	}




	public static void removeMaximumValues(LinkedList<String> list, int N) {

		/* IMPLEMENT THIS METHOD! */

	}

	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		/* IMPLEMENT THIS METHOD! */

		return true; // this line is here only so this code will compile if you don't modify it
	}


	/*public static void main(String[] args) {
		LinkedList<Integer> LL = new LinkedList<Integer>();
		insertSorted(LL, 2);
		arr = new Array[LL.size()];
		arr = LL.toArray();
	 */
}




