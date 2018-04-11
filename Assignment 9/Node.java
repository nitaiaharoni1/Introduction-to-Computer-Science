/*
 * 
 * Assignment number : 9.2
 * 
 * File Name : Node
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
 * Represents a node in a doubly linked list. Each node points to a MemoryBlock
 * object.
 */
public class Node {
	Node next;
	Node prev;
	MemoryBlock block;

	/**
	 * Constructs a new node pointing to the given memory block
	 * 
	 * @param block the given memory block
	 */
	public Node(MemoryBlock block) {
		this.block = block;
		this.next = null;
		this.prev = null;
	}

	/**
	 * A textual representation of this node, useful for debugging. (See the
	 * test output for examples).
	 */
	public String toString() {
		StringBuilder str = new StringBuilder("");
		str.append(block.toString());
		return str.toString();
	}
}