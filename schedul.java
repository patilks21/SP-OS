package schedul;

import java.util.Scanner;

public class schedul {
	Scanner sc=new Scanner(System.in);
	void rr()
	{
		String process[] = new String[10];//stores names of processes
		int cpu[] = new int[10];//stores cpu time
		int count,brust;//count is no. of processes , brust is the cycle time
		int rem[]= new int[10];//stores the remaining cpu time 
		int cu[]= new int[10];//stores the cpu time for each process
		int finishtime[]=new int[10];
		int arrivaltime[]=new int[10];
		int turnaroundtime[]=new int[10];
		int waittime[]=new int[10];
		System.out.println("Enter number of processes");
		count=sc.nextInt();
		System.out.println("Enter the names of processes");
		for(int i=0;i<count;i++)
		{
			process[i]=sc.next();
		}
		System.out.println("Enter the cpu requirement of processes");
		for(int i=0;i<count;i++)
		{
			cpu[i]=sc.nextInt();
			cu[i]=cpu[i];
		}
		System.out.println("Enter the arrival time of processes");
		for(int i=0;i<count;i++)
		{
			arrivaltime[i]=sc.nextInt();
		}
		System.out.println("enter brust or time slice time");
		brust=sc.nextInt();
		rem=cpu;
		int end=0;
		int currtime=0;//stoes the current time used to handle the arrival time problems 
		while(end==0)
		{
			for(int i=0;i<count;i++)
			{
				if(rem[i]>0 && arrivaltime[i]<=currtime)
				{
					if(rem[i]>brust)
					{
						System.out.println(process[i]+" ");
						rem[i]=rem[i]-brust;
						currtime=currtime+brust;
					}
					else
					{
						System.out.println(process[i]+" ");
						currtime=currtime+rem[i];
						rem[i]=0;
						finishtime[i]=currtime;
					}
				}
			}
			int flag=0;				//condition to check if all the processes are completed or not
			for(int i=0;i<count;i++)
			{
				if(rem[i]==0)
				{
					flag=1;
				}
				else
				{
					flag=0;
					break;
				}
			}
			if(flag==1)
			{
				end=1;				//if all done then assign end as 1 which will end the while loop
			}
		}
		for(int i=0;i<count;i++)//calculating turnaround time
		{
			turnaroundtime[i]=finishtime[i]-arrivaltime[i];
		}
		for(int i=0;i<count;i++)//cal wait time
		{
			waittime[i]=turnaroundtime[i]-cu[i];
		}
		System.out.println("process finishtime turnaroundtime waittime ");
		for(int i=0;i<count;i++)
		{
			System.out.println(process[i]+" "+finishtime[i]+" "+turnaroundtime[i]+" "+waittime[i]);
		}
	}

	public static void main(String[] args) {
		schedul s=new schedul();
		s.rr();

	}

}
