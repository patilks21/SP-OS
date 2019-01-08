import java.util.HashMap;
import java.io.*;
public class table {
	HashMap<String, String>opcode=new HashMap<>();
	table()
	{
		
		opcode.put("STOP", "00");
		opcode.put("ADD", "01");
		opcode.put("SUB", "02");
		opcode.put("MULT", "03");
		opcode.put("MOVER", "04");
		opcode.put("MOVEM", "05");
		opcode.put("COMP", "06");
		opcode.put("BC", "07");
		opcode.put("DIV", "08");
		opcode.put("READ", "09");
		opcode.put("PRINT", "10");
	}
	
	public static void main(String[] args) {
		table t=new table();
		System.out.println(t.opcode.values());
	}

}
