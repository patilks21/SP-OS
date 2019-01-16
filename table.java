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
		
		dir.put("START", "001");
		dir.put("END", "002");
		dir.put("DS", "003");
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
			
			return word;
		
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
		 while ( ss!= null) 
		 {
			 String sw[];
			 sw=ss.split(" ");
			 /*if(sw[0]=="START")
	    	 {System.out.print(" ** ");
	    		 lc=Integer.parseInt(sw[1]);
	    		 String so=getcode(sw[0]);
	    		 System.out.print(so+" "+sw[1]);
		    	 bw.write(so+" "+sw[1]);
	    	 }
			 if(sw.length>4)
			 {
				 System.out.print("error in input");break;
			 }
			 
			 if(sw.length>2)
			 if(sw[1]=="DS")
	    	 {System.out.print(" ** ");
	    		 symbol.putIfAbsent(sw[0], Integer.toString(lc));
	    	 }*/
			 //else
			 { 
				 
				 System.out.print(lc+" ");
				 bw.write(lc+" ");
				 for(int i=0;i<sw.length;i++)
				 {
		    	 
					
					 String so=getcode(sw[i]);
					 if(so=="001")
					 {
						 lc=Integer.parseInt(sw[1]);break;
					 }
					 if(so=="003")
					 {
						 symbol.replace(sw[0], null, Integer.toString(lc));
						 
					 }
					 if(so==sw[i])
					 {
						 symbol.put(so, null);
		    		 
						 //if(so[0]=="=");
		    		 
					 }
		    	
					 System.out.print(so+" ");
					 bw.write(so+" ");
				 }
				 System.out.println("");
				 bw.write("\n");
		     
				 //ss=br.readLine();
			 }
			 lc++;
			 ss=br.readLine();
		 }
		
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		table t=new table();
		t.pass1();
		System.out.println(t.symbol.entrySet());
	}

}
