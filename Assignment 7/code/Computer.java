/*
 * 
 * Assignment number : 7.3
 * 
 * File Name : Computer
 * 
 * Name : Nitai Aharoni
 * 
 * Student ID : 203626742
 * 
 * Email : Nitai.Aharoni@post.idc.ac.il
 * 
 */

/**
 * Represents a Vic computer. It is assumed that users of this class are
 * familiar with the Vic computer, described in www.idc.ac.il/vic. The
 * Computer's hardware consists of the following components:
 * 
 * Data register: a register. Program counter: a register. Input unit: a stream
 * of numbers. In this implementation, the input unit is simulated by a text
 * file. When the computer is instructed to execute a READ command, it reads
 * the next number from this file and puts it in the data register. Output
 * unit: a stream of numbers. In this implementation, the output unit is
 * simulated by standard output (by default, the console). When the computer is
 * instructed to execute a WRITE command, it writes the current value of the
 * data register to the standard output. Processor: in this implementation, the
 * processor is emulated by the run method of this class.
 * 
 * The Computer's software is a program written in the numeric Vic machine
 * language. Such a program normally resides in a text file that can be loaded
 * into the computer's memory. This is done by the loadProgram method of this
 * class.
 */

public class Computer {

	/**
	 * This constant represents the size of the memory unit of this Computer
	 * (number of registers). The default value is 100.
	 */
	public final static int MEM_SIZE = 100;

	/**
	 * This constant represents the memory address at which the constant 0 is
	 * stored. The default value is MEM_SIZE - 2.
	 */
	public final static int LOCATION_OF_ZERO = MEM_SIZE - 2;

	/**
	 * This constant represents the memory address at which the number 1 is
	 * stored. The default value is MEM_SIZE - 1.
	 */
	public final static int LOCATION_OF_ONE = MEM_SIZE - 1;

	// Op-code definitions:
	private final static int READ = 8;

	private final static int ADD = 1;

	private final static int SUB = 2;

	private final static int LOAD = 3;

	private final static int STORE = 4;

	private final static int GOTO = 5;

	private final static int GOTOZ = 6;

	private final static int GOTOP = 7;

	private final static int WRITE = 9;

	private Memory MEM;

	private Register DATA_REG;

	private Register COUNTER;

	private Memory INPUT;

	private int INPUT_COUNTER;

	/**
	 * Constructs a Vic computer. Specifically: constructs a memory that has
	 * MEM_SIZE registers, a data register, and a program counter. Next, resets
	 * the computer (see the reset method API). Note: the initialization of the
	 * input unit and the loading of a program into memory are not done by the
	 * constructor. This is done by the public methods loadInput and
	 * loadProgram, respectively.
	 */
	public Computer() {
		this.MEM = new Memory(MEM_SIZE);
		MEM.setValue(LOCATION_OF_ONE, 1);
		MEM.setValue(LOCATION_OF_ZERO, 0);
		this.DATA_REG = new Register();
		this.COUNTER = new Register();
	}

	/**
	 * Resets the computer. Specifically: Resets the memory, sets the memory
	 * registers at addresses LOCATION_OF_ZERO and LOCATION_OF_ONE to 0 and to
	 * 1, respectively, sets the data register and the program counter to 0.
	 */
	public void reset() {
		MEM.reset();
		MEM.setValue(99, 1);
		DATA_REG.setValue(0);
		COUNTER.setValue(0);
		INPUT.reset();
		INPUT_COUNTER = 0;
	}

	/**
	 * Executes the program currently stored in memory. This is done by
	 * affecting the following fetch-execute cycle: Fetches from memory the
	 * current word (3-digit number), i.e. the contents of the memory register
	 * whose address is the current value of the program counter. Extracts from
	 * this word the op-code (left-most digit) and the address (next 2 digits).
	 * Next, executes the command mandated by the op-code, using the address if
	 * necessary. As a side-effect of executing this command, modifies the
	 * program counter. Next, loops to fetch the next word, and so on.
	 */
	public void run() {
		while (MEM.getValue(COUNTER.getValue()) != 0) {
			execLoad(COUNTER.getValue());
		}
		System.out.println("Run terminated normally");
	}

	// Private execution routines, one for each Vic command
	private void execLoad(int addr) {
		int opCode = MEM.getValue(addr) / 100;
		int address = 0;
		if (opCode != 8 && opCode != 9) {
			address = MEM.getValue(addr) % 100;
		}
		switch (opCode) {
		case READ:
			READ();
			break;
		case WRITE:
			WRITE();
			break;
		case ADD:
			ADD(address);
			break;
		case SUB:
			SUB(address);
			break;
		case LOAD:
			LOAD(address);
			break;
		case STORE:
			STORE(address);
			break;
		case GOTO:
			GOTO(address);
			break;
		case GOTOZ:
			GOTOZ(address);
			break;
		case GOTOP:
			GOTOP(address);
			break;
		}
		COUNTER.addOne();

	}

	private void READ() {
		DATA_REG.setValue(INPUT.getValue(INPUT_COUNTER));
		INPUT_COUNTER++;
	}

	private void WRITE() {
		System.out.println(DATA_REG.getValue());
	}

	private void ADD(int address) {
		DATA_REG.setValue(DATA_REG.getValue() + MEM.getValue(address));
	}

	private void SUB(int address) {
		DATA_REG.setValue(DATA_REG.getValue() - MEM.getValue(address));
	}

	private void LOAD(int address) {
		DATA_REG.setValue(MEM.getValue(address));
	}

	private void STORE(int address) {
		MEM.setValue(address, DATA_REG.getValue());
	}

	private void GOTO(int address) {
		COUNTER.setValue(address - 1);
	}

	private void GOTOZ(int address) {
		if (DATA_REG.getValue() == 0) {
			COUNTER.setValue(address - 1);
		}
	}

	private void GOTOP(int address) {
		if (DATA_REG.getValue() > 0) {
			COUNTER.setValue(address - 1);
		}
	}

	/**
	 * Loads a program into memory, starting at address 0, using the standard
	 * input. The program is stored in a text file whose name is the given
	 * fileName. It is assumed that the file contains a stream of valid
	 * commands written in the numeric Vic machine language (described in
	 * www.idc.ac.il/vic). The program is stored in the memory, one command per
	 * memory register, starting at address 0.
	 */
	public void loadProgram(String fileName) {
		StdIn.setInput(fileName);
		int[] program = StdIn.readAllInts();
		for (int i = 0; i < program.length; i++) {
			MEM.setValue(i, program[i]);
		}
	}

	/**
	 * Initializes the input unit from a given text file using the standard
	 * input. It is assumed that the file contains a stream of valid data
	 * values, each being an integer in the range -999 to 999. Each time the
	 * computer is instructed to execute a READ command, the next line from
	 * this file is read and placed in the data register (this READ logic is
	 * part of the run method implementation). Thus, the role of this method is
	 * to initialize the file in order to enable the execution of subsequent
	 * READ commands.
	 */
	public void loadInput(String fileName) {
		StdIn.setInput(fileName);
		int[] inputs = StdIn.readAllInts();
		this.INPUT = new Memory(inputs.length);
		for (int i = 0; i < inputs.length; i++) {
			INPUT.setValue(i, inputs[i]);
		}
	}

	/**
	 * This method is used for debugging purposes. It displays the current
	 * contents of the data register, the program counter, and the memory
	 * (first and last 10 memory cells).
	 */
	public String toString() {
		String str = "";
		str += "D Register = " + DATA_REG.getValue() + "\n";
		str += "PC Register = " + COUNTER.getValue() + "\n";
		str += "Memory State: \n" + MEM.toString();
		return str;
	}
}