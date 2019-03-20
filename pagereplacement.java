import java.util.*;
public class pagereplacement
{
	Scanner sc=new Scanner(System.in);
	String seq="";
	String page[];
	int framesize;
	void input()
	{
		System.out.print("enter the sequence");
		seq=sc.nextLine();
		System.out.print("enter the frame size");
		framesize=sc.nextInt();
		page=seq.split("");
	}
	void fifo()
	{
		Queue<String> q = new LinkedList<>();
		int size=page.length;
		int f=0,h=0;
		for(int i=0;i<size;i++)
		{
			if(q.contains(page[i]))
			{
				h++;
			}
			else
			{
				f++;
				if(q.size()<3)
				{
					q.add(page[i]);
				}
				else
				{
					q.remove();
					q.add(page[i]);
				}
				System.out.println(q);
			}
		}
		System.out.println("fault:"+f+"hit:"+h);
		float fr=f/size*100;
		float hr=h/size*100;
		System.out.println("Fault rate is : "+fr);
		System.out.println("Hit rate is : "+hr);
	}
	void lru()
	{
		List<String> l = new ArrayList<String>();
		int size=page.length;
		int f=0,h=0;
		for(int i=0;i<size;i++)
		{
			if(l.contains(page[i]))
			{
				h++;
				l.remove(page[i]);
				l.add(page[i]);
				System.out.println(l);
			}
			else
			{
				f++;
				if(l.size()<3)
				{
					l.add(page[i]);
				}
				else
				{
					l.remove(0);
					l.add(page[i]);
				}
				System.out.println(l);
			}
		}
		System.out.println("fault:"+f+"hit:"+h);
		float fr=f/size*100;
		float hr=h/size*100;
		System.out.println("Fault rate is : "+fr);
		System.out.println("Hit rate is : "+hr);
	}
	void optimum()
	{
		List<String> l = new ArrayList<String>();
		int size=page.length;
		int f=0,h=0;
		for(int i=0;i<size;i++)
		{
			if(l.contains(page[i]))
			{
				h++;
				
			}
			else
			{
				f++;
				if(l.size()<3)
				{
					l.add(page[i]);
					System.out.println(l);
				}
				else
				{
					List<String> a =new ArrayList<>();
					for(int j=i+1;j<size;j++)
					{
						if(a.size()<=framesize && l.contains(page[j]))
						{
							if(a.contains(page[j])){}
							else 
							{
								a.add(page[j]);
							}
						}
						else{break;}
					}
					if(l.contains(a.get(2)))
					{
						l.remove(a.get(2));
						l.add(page[i]);
					}
					else if(l.contains(a.get(1)))
					{
						l.remove(a.get(1));
						l.add(page[i]);
					}
					System.out.println(l);
				}
				
			}
		}
		System.out.println("fault:"+f+"hit:"+h);
	}
	public static void main(String[] args) 
	{
		pagereplacement pr=new pagereplacement();
		pr.input();
		pr.optimum();
	}

}
