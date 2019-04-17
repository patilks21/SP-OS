package bankers;

import java.util.*;

public class bankeralgo {
	Scanner sc=new Scanner(System.in);
	int allocation[][]=new int[10][10];
	int max[][]=new int[10][10];
	int need[][]=new int[10][10];
	int available[]=new int[10];
	int process,resource;
	List<Integer> seq=new ArrayList<>();;
	void input()
	{
		System.out.println("Enter no. of processes and resources");
		process=sc.nextInt();
		resource=sc.nextInt();
		System.out.println("Enter the allocation matrix");
		for(int i=0;i<process;i++)
		{
			for(int j=0;j<resource;j++)
			{
				allocation[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the max matrix");
		for(int i=0;i<process;i++)
		{
			for(int j=0;j<resource;j++)
			{
				max[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the available resources");
		for(int j=0;j<resource;j++)
		{
			available[j]=sc.nextInt();
		}
	}
	void compute()
	{
		for(int i=0;i<process;i++)			//calculation of need matrix
		{
			for(int j=0;j<resource;j++)
			{
				need[i][j]=max[i][j]-allocation[i][j];
			}
		}
		int i=0;							// here i is the process number
		
		while(seq.size()<process)			//deciding the process
		{	
			int flag=0;
			if(!seq.contains(i)) 			//checks if process already present or not
			{
				for(int r=0;r<resource;r++)	//checks availability for each resource
				{
					if(need[i][r]<=available[r])
					{
						flag=1;
					}
					else{flag=0;break;}
				}
				if(flag==1)
				{
					seq.add(i);				//if conditions are set it is added to seq list which contains result
					for(int a=0;a<resource;a++)
					{
						available[a]=available[a]+need[i][a];
					}
				}
			}
			i++;
			if(i==process){i=0;}
		}
		System.out.println(seq.toString());
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		bankeralgo ba=new bankeralgo();
		ba.input();
		ba.compute();
	}

}