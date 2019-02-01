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
public class macropass1 
{
	static LinkedList<PTAB> ptab=new LinkedList<PTAB>();
	static LinkedList<MDT> mdt=new LinkedList<MDT>();
	static LinkedList<MNT> mnt=new LinkedList<MNT>();
	void passone() throws IOException
	{
		
		FileReader f1=null;
		try{
			f1=new FileReader("macro.txt");
		}
		catch (IOException e)
		{
			System.out.print("file not found here");
		}
		BufferedReader br=new BufferedReader(f1);
		String ss;
		ss=br.readLine();
		String tk[];
		tk=ss.split(" ");
		if(tk[0].equals("MACRO"))
		{
			ss=br.readLine();
			String tkk[];
			tkk=ss.split(" ");
			for(int i=1;i<tkk.length;i++)
			{
				if(tkk[i].contains("="))
				{
					String v[]=tkk[i].split("=");
					PTAB p=new PTAB();
					p.para=v[0];
					p.dvalue=v[1];
					ptab.add(p);
				}
				else
				{
					PTAB p=new PTAB();
					p.para=tkk[i];
					ptab.add(p);
				}
			}
			MNT m=new MNT();
			m.mname=tkk[0];
			mnt.add(m);
		}
		ss=br.readLine();
		while(ss!=null)
		{
			String tkk[];
			tkk=ss.split(" ");
			if(tkk[0].endsWith("MEND"))
			{
				break;
			}
			MDT m=new MDT();
			
			m.t1=tkk[0];
			if(tkk[1].contains("&"))
			{
				String n="p";
				int i=0;
				for(PTAB p:ptab)
				{
					if(tkk[1].equals(p.para))
					{
						break;
					}
					i++;
				}
				n=n.concat(Integer.toString(i));
				m.t2=n;
			}else{m.t2=tkk[1];}
			if(tkk[2].contains("&"))
			{
				String n="p";
				int i=0;
				for(PTAB p:ptab)
				{
					if(tkk[2].equals(p.para))
					{
						break;
					}
					i++;
				}
				n=n.concat(Integer.toString(i));
				m.t3=n;
			}else{m.t3=tkk[2];}
			
			mdt.add(m);			
			ss=br.readLine();
		}
		ss=br.readLine();
		String cp[]=ss.split(" ");
		int i=1;
		for(PTAB p:ptab)
		{
			if(i<cp.length)
			{
				p.value=cp[i];
				i++;
			}
		}
		
		FileWriter fos=new FileWriter("mnt.txt");
		BufferedWriter brr=new BufferedWriter(fos);
		for(MNT m:mnt)
		{
			brr.write(m.mname+"\n");
		}
		brr.close();
		FileWriter fos1=new FileWriter("mdt.txt");
		BufferedWriter brr1=new BufferedWriter(fos1);
		for(MDT m:mdt)
		{
			brr1.write(m.t1+" "+m.t2+" "+m.t3+"\n");
		}
		brr1.close();
		FileWriter fos2=new FileWriter("ptab.txt");
		BufferedWriter brr2=new BufferedWriter(fos2);
		for(PTAB m:ptab)
		{
			brr2.write(m.para+" "+m.value+" "+m.dvalue+"\n");
		}
		brr2.close();
		
	}
	public static void main(String[] args) throws IOException 
	{
		macropass1 p1=new macropass1();
		
		p1.passone();
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
