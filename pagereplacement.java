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
				if(q.size()<framesize)
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
				if(l.size()<framesize)
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
				if(l.size()<framesize)
				{
					l.add(page[i]);
				}
				else
				{
					
					List<String> a =new ArrayList<>();//new list containing future pages 
					for(int j=i+1;j<size;j++)
					{
						if(a.size()<=framesize && l.contains(page[j]))//future pages that exist into current page list
						{
							if(a.contains(page[j])){}//skips if page already exist
							else 
							{
								a.add(page[j]);//adds page to future list
							}
						}
						else{}
					}
					int as=a.size();//size of future list
					if(as==l.size())//future list and current list of same size then
					{
						
						if(l.contains(a.get(as-1)))//remove from the current page list the last element of future page list
						{
							l.remove(a.get(as-1));
							l.add(page[i]);
						}
						else if(l.contains(a.get(as-2)))
						{
							l.remove(a.get(as-2));
							l.add(page[i]);
						}
						else
						{
							l.remove(a.get(as-3));
							l.add(page[i]);
						}
					}
					else
					{
						List<String> ex =new ArrayList<>(); //list of extra elements
						ex.addAll(l);//copy current pages into new list
						ex.removeAll(a);//remove the common elements of list a and current page list l
						System.out.println("extra is "+ex);
						l.remove(ex.get(0));//remove that extra element from main page list 
						l.add(page[i]);		//add the new page into main list		
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
