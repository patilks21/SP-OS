import java.util.HashMap;
import java.io.*;

public class secpass 
{
	HashMap<String,String>symbol=new HashMap<>();
	HashMap<String,String>literal=new HashMap<>();
	@SuppressWarnings("unchecked")
	secpass() throws IOException, ClassNotFoundException
	{
		FileInputStream fis=new FileInputStream("outputsymtab.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        symbol=(HashMap<String, String>) ois.readObject();
        FileInputStream fis1=new FileInputStream("outputlittab.txt");
        ObjectInputStream ois1=new ObjectInputStream(fis1);
        literal=(HashMap<String, String>) ois1.readObject();
        ois.close();
        ois1.close();
	}
	 void pass() throws IOException
	{
		FileReader f1=new FileReader("output.txt");
		BufferedReader br=new BufferedReader(f1);
		FileWriter f2=new FileWriter("final.txt");
		BufferedWriter bw=new BufferedWriter(f2);
		String ss=br.readLine();
		while(ss != null)
		{
			String sw[];
			sw=ss.split(" ");
			for(int i=0;i<sw.length;i++)
			{
				if(sw[i].startsWith("S"))
				{
					String s=sw[i];
					String k=s.substring(1);
					String v=symbol.get(k);
					System.out.print(v+" ");
					bw.write(v+" ");
					
				}
				else if(sw[i].startsWith("L"))
				{
					String s=sw[i];
					String k=s.substring(1);
					String v=literal.get(k);
					System.out.print(v+" ");
					bw.write(v+" ");
				}
				else
				{
					System.out.print(sw[i]+" ");
					bw.write(sw[i]+" ");
				}
				
			}
			System.out.println("\n");
			bw.write("\n");
			ss=br.readLine();
		}
		bw.close();
		br.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		secpass sec=new secpass();
		sec.pass();
	}

}
