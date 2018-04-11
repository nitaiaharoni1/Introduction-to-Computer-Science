/*
 * 
 * Assignment number : 7.2
 * 
 * File Name : Memory
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

/**
 * Represents a random access memory (RAM) unit. A Memory is an indexed
 * sequence of registers. The Memory enables reading from, or writing to, any
 * individual register according to a given index. The index is typically
 * called "address". The addresses run from 0 to the memory's size, minus 1.
 */

public class Memory {

	private Register[] m; // an array of Register objects

	/**
	 * Constructs a memory of size registers, and sets all the register values
	 * to 0.
	 */
	public Memory(int size) {
		m = new Register[size];
		for (int i = 0; i < m.length; i++) {
			m[i] = new Register();
		}
	}

	/** Sets the values of all the registers in this memory to 0. */
	public void reset() {
		for (int i = 0; i < m.length; i++) {
			m[i].setValue(0);
		}
	}

	/**
	 * Returns the value of the register whose address is the given address.
	 */
	public int getValue(int address) {
		return m[address].getValue();
	}

	/** Sets the register in the given address to the given value. */
	public void setValue(int address, int value) {
		m[address].setValue(value);
	}

	/**
	 * Returns a subset of the memory's contents, as a formated string.
	 * Specifically: Returns the first 10 registers (where the top of the
	 * program normally resides) and the bottom 10 registers (where the
	 * variables normally reside). For each register, returns the register's
	 * address and value.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			str.append(String.format("%2s", i) + "\t"
					+ String.format("%3s", m[i].getValue()) + "\n");
		}
		str.append("..\n");
		for (int j = m.length - 10; j < m.length; j++) {
			str.append(String.format("%2s", j) + "\t"
					+ String.format("%3s", m[j].getValue()) + "\n");
		}
		return str.toString();
	}
}
