/*
 * 
 * Assignment number : 9.4
 * 
 * File Name : LinkedList
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
 * Represents a list of Nodes. The list has a "first" pointer, which points to
 * the first node in the list, a "last" pointer, which points to the last node
 * in the list, and a size, which is the number of nodes in the list.
 */
public class LinkedList {

	// Three package-private fields come here.
	Node first;
	int size;

	/**
	 * Constructs a new doubly-connected linked list.
	 */
	public LinkedList() {
		this.first = new Node(new MemoryBlock(0, 0));
		this.size = 0;
	}

	/**
	 * Gets the node located at the given index in this list.
	 * 
	 * @param index the index of the node to retrieve, between 0 and size
	 * @throws IllegalArgumentException if index is negative or greater than
	 *         the list's size
	 * @return the node at the given index
	 */
	public Node getNode(int index) {
		if (index >= this.size || index < 0) {
			throw new IllegalArgumentException("illegal index " + index);
		}
		ListIterator it = this.iterator();
		for (int i = 0; i < index; i++) {
			if (it.hasNext())
				it.next();
		}
		return it.current;
	}

	/**
	 * Creates a new Node object that points to the given memory block, and
	 * inserts the node to this list immediately prior to the given index
	 * (position in this list).
	 * <p>
	 * If the given index is 0, the new node becomes the first node in this
	 * list.
	 * <p>
	 * If the given index equals the size of this list, the new node becomes
	 * the last node in this list.
	 * 
	 * @param block the memory block to be inserted into the list
	 * @param index the index before which the memory block should be inserted
	 * @throws IllegalArgumentException if index is negative or greater than
	 *         the list's size
	 */
	public void add(int index, MemoryBlock block) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("illegal index " + index);
		}
		Node insert = new Node(block);
		Node current = first.next;
		Node prev = first;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		prev.next = insert;
		insert.next = current;
		insert.prev = prev;
		current = null;
		this.size++;
	}

	/**
	 * Creates a new node with a reference to the given memory block, and
	 * appends it to the end of this list (the node will become the list's last
	 * node).
	 * 
	 * @param block the given memory block
	 */
	public void addLast(MemoryBlock block) {
		this.add(this.size, block);
	}

	/**
	 * Creates a new node with a reference to the given memory block, and
	 * inserts it at the beginning of this list (the node will become the
	 * list's first node).
	 * 
	 * @param block the given memory block
	 */
	public void addFirst(MemoryBlock block) {
		this.add(0, block);
	}

	/**
	 * Gets the memory block located at the given index in this list.
	 * 
	 * @param index the index of the retrieved memory block
	 * @return the memory block at the given index
	 * @throws IllegalArgumentException if index is negative or greater than or
	 *         equal to size
	 */
	public MemoryBlock getBlock(int index) {
		return this.getNode(index).block;
	}

	/**
	 * Gets the index of the node pointing to the given memory block.
	 * 
	 * @param block the given memory block
	 * @return the index of the block, or -1 if the block is not in this list
	 */
	public int indexOf(MemoryBlock block) {
		ListIterator it = this.iterator();
		for (int i = 0; i < this.size; i++) {
			if (getBlock(i).equals(block))
				return i;
			if (it.hasNext())
				it.next();
		}
		return -1;
	}

	/**
	 * Removes the given node from this list.
	 * 
	 * @param node the node that will be removed from this list
	 */
	public void remove(Node node) {
		if (node == null)
			throw new IllegalArgumentException("illegal Argument " + node);
		Node prev = first;
		Node current = first.next;
		for (int i = 0; i < this.size; i++) {
			if (current == node) {
				prev.next = current.next;
				current = null;
				size--;
				break;
			} else {
				prev = current;
				current = current.next;
			}
		}
	}

	/**
	 * Removes from this list the node which is located at the given index.
	 * 
	 * @param index the location of the node that has to be removed.
	 * @throws IllegalArgumentException if index is negative or greater than or
	 *         equal to size
	 */
	public void remove(int index) {
		this.remove(this.getNode(index));
	}

	/**
	 * Removes from this list the node pointing to the given memory block.
	 * 
	 * @param block the memory block that should be removed from the list
	 * @throws IllegalArgumentException if the given memory block is not in
	 *         this list
	 */
	public void remove(MemoryBlock block) {
		this.remove(this.indexOf(block));
	}

	/**
	 * Returns an iterator over this list, starting with the first element.
	 */
	public ListIterator iterator() {
		return new ListIterator(first.next);
	}

	/**
	 * A textual representation of this list, useful for debugging.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder("");
		ListIterator it = this.iterator();
		if (it.hasNext()) {
			for (int i = 0; i < this.size; i++) {
				str.append(it.current.toString());
				str.append(",");
				it.next();
			}

		}
		if (str.length() > 0)
			str.delete(str.length() - 1, str.length());
		return str.toString();
	}
}