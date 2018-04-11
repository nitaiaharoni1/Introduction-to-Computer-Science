
public class VicSimulator {
	public static void main(String[] args) {
		// Constructs a Vic computer, loads the given program, and executes it.
		Computer vic = new Computer();  
		vic.loadProgram(args[0]);   // args[0] = Vic program
		if (args.length > 1) {      // args[1] = program's input (optional)
			vic.loadInput(args[1]);
		}
		vic.run();
		System.out.println(vic);	
	}
}