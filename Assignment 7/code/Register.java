/*
 * 
 * Assignment number : 7.1
 * 
 * File Name : Register
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

/**
 * Represents a register. A register is the basic storage unit of the Vic
 * computer.
 */

public class Register {

	private int value; // the current value of this register

	/** Constructs a register and sets its value to 0. */
	public Register() {
		this.value = 0;
	}

	/** Constructs a register and sets its value to the given value. */
	public Register(int value) {
		this.value = value;
	}

	/** Sets the value of this register to the given value. */
	public void setValue(int value) {
		this.value = value;
	}

	/** Increments the value of this register by 1. */
	public void addOne() {
		this.value = value + 1;
	}

	/** Returns the value of this register, as an int. */
	public int getValue() {
		return value;
	}

	/** Returns the value of this register, as a String. */
	public String toString() {
		String str = "" + value;
		return str;
	}
}
