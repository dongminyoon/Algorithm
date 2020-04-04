import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon10828 {
	static int stack[];
	static int size ;
	static int top;
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = sc.nextInt();
		stack = new int[N];
		top = -1;
		
		for(int i = 0 ; i<N ; i ++)
		{	
			String s  = sc.next();
			
			if(s.equals("push"))
			{
				
				push(sc.nextInt());
				
			}
			else if(s.equals("pop"))
			{
				bw.write(pop()+"\n");
			}
			else if(s.equals("size"))
			{
				bw.write(top+1+"\n");
			}
			else if(s.equals("empty"))
			{
				bw.write(empty()+"\n");
			}
			else if(s.equals("top"))
			{
				if(top == -1 )
				{
					bw.write("-1\n");
				}
				else
				{
					bw.write(stack[top]+"\n");	
				}
				
			}
		}
		
		bw.flush();
		bw.close();
		
	}

	public static void push(int i)
	{
		stack[++top] = i;
	}
	public static int pop()
	{	
		if(top == -1)
		{	
			return -1;
		}
		else
		{
			return stack[top--] ; 
		}
		
	
	}
	public static int empty()
	{
		if(top == -1)
		{
			return 1 ;
		}
		else
		{
			return 0;
		}
	
		
	}	
}
