import java.io.*;
import java.util.LinkedList;
class PTAB
{
	String para;
	String value;
	String dvalue;
}
class MDT
{
	String t1;
	String t2;
	String t3;
}
class MNT
{
	String mname;
}
public class macropass2 
{
	static LinkedList<PTAB> ptab=new LinkedList<PTAB>();
	static LinkedList<MDT> mdt=new LinkedList<MDT>();
	static LinkedList<MNT> mnt=new LinkedList<MNT>();
	void pass2() throws IOException
	{
		FileReader fr=new FileReader("mnt.txt");
		BufferedReader br=new BufferedReader(fr);
		String ss=br.readLine();
		while(ss!=null){
		String tk[]=ss.split(" ");
		MNT m=new MNT();
		m.mname=tk[0];
		mnt.add(m);
		ss=br.readLine();
		}
		br.close();
		FileReader fr1=new FileReader("mdt.txt");
		BufferedReader br1=new BufferedReader(fr1);
		ss=br1.readLine();
		while(ss!=null){
		String tk[]=ss.split(" ");
		MDT m=new MDT();
		m.t1=tk[0];
		m.t2=tk[1];
		m.t3=tk[2];
		mdt.add(m);
		ss=br1.readLine();
		}
		br1.close();
		FileReader fr2=new FileReader("ptab.txt");
		BufferedReader br2=new BufferedReader(fr2);
		ss=br2.readLine();
		while(ss!=null){
		String tk[]=ss.split(" ");
		PTAB m=new PTAB();
		m.para=tk[0];
		m.value=tk[1];
		m.dvalue=tk[2];
		ptab.add(m);
		ss=br2.readLine();
		}
		br2.close();
		
		
		
		
	}

	
	public static void main(String[] args) throws IOException 
	{
		macropass2 p2=new macropass2();
		
		p2.pass2();
		System.out.println("MNT");
		for(MNT m:mnt)
		{
			System.out.println(m.mname);
		}
		System.out.println("PTAB");
		for(PTAB p:ptab)
		{
			System.out.println(p.para+" "+p.value+" "+p.dvalue);
		}
		System.out.println("MDT");
		for(MDT m:mdt)
		{
			System.out.println(m.t1+" "+m.t2+" "+m.t3);
		}
	}

}
