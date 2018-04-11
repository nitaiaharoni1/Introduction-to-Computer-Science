/*
 * 
 * Assignment number : 9.3
 * 
 * File Name : ListIterator
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

package MMSSolution;

/**
 * Represents an iterator of a linked list.
 */
public class ListIterator {

	/** current position in the list (cursor) */
	Node current;

	/**
	 * Constructs a list iterator, starting at the given node
	 */
	public ListIterator(Node node) {
		current = node;
	}

	/**
	 * Checks if this iterator has more nodes to process
	 */
	public boolean hasNext() {
		return (current != null);
	}

	/**
	 * Returns the current element in the list and advances the cursor
	 */
	public MemoryBlock next() {
		Node currentNode = current;
		current = current.next;
		return currentNode.block;
	}
}