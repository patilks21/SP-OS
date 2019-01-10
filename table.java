import java.util.HashMap;
import java.io.*;
public class table {
	HashMap<String, String>opcode=new HashMap<>();
	HashMap<String,String>reg=new HashMap<>();
	HashMap<String,String>cond=new HashMap<>();
	HashMap<String,String>dir=new HashMap<>();
	HashMap<String,String>symbol=new HashMap<>();
	HashMap<String,String>literal=new HashMap<>();
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
		
		reg.put("AREG", "1");
		reg.put("BREG", "2");
		reg.put("CREG", "3");
		reg.put("DREG", "4");
		
		cond.put("LT", "1");
		cond.put("LE", "2");
		cond.put("EQ", "3");
		cond.put("GT", "4");
		cond.put("GE", "5");
		cond.put("ANY", "6");
		
		dir.put("START", "1");
		dir.put("END", "2");
		
	}
	
	String getcode(String word)
	{
		String code=null;
		if((code=opcode.get(word))!=null)
			return code;
		if((code=dir.get(word))!=null)
			return code;
		if((code=reg.get(word))!=null)
			return code;
		if((code=cond.get(word))!=null)
			return code;
		else
			
			return "error";
		
	}
	
	void pass1() throws IOException{
		int lc=0;
		int sp=0,lp=0;
		FileReader f1=null;
		FileWriter f2=null;
		try{
			f1=new FileReader("asm.txt");
			f2=new FileWriter("output.txt");
		}
		catch (IOException e)
		{
			System.out.print("file not found here");
		}
		BufferedReader br=new BufferedReader(f1);
		BufferedWriter bw=new BufferedWriter(f2);
		String ss;
		ss=br.readLine();
		
		 while ( ss!= null) {
			 String sw[];
			 sw=ss.split(" ");
			 if(sw.length>4)
			 {
				 System.out.print("error in input");
			 }
		     for(int i=0;i<sw.length;i++)
		     {
		    	 String so=getcode(sw[i]);
		    	 
		    	 System.out.print(so+" ");
		     }
		     System.out.println("");
		     
		     ss=br.readLine();
		   }
		
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		table t=new table();
		System.out.println(t.opcode.entrySet());
		System.out.println(t.reg.entrySet());
		System.out.println(t.cond.entrySet());
		System.out.println(t.dir.entrySet());
		t.pass1();
		
	}

}
