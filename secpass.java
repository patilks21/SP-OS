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
	
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		secpass sec=new secpass();
		System.out.println(sec.symbol.entrySet());
		System.out.println(sec.literal.entrySet());
	}

}
