import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon10845 {

	static int queue[];
	static int size ;
	static int front;
	static int back;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		queue = new int[10001];
		front = 0 ;
		back = 0;
		
		for(int i = 0 ; i<N ; i ++)
		{	
			st = new StringTokenizer(br.readLine());	
			String s = st.nextToken();
			if(s.equals("push"))
			{
				push(Integer.parseInt(st.nextToken()));
				
			}
			else if(s.equals("pop"))
			{
				bw.write(pop()+"\n");
			}
			else if(s.equals("size"))
			{
				bw.write(size()+"\n");
			}
			else if(s.equals("empty"))
			{
				bw.write(empty()+"\n");
			}
			else if(s.equals("front"))
			{
				bw.write(front()+"\n");
			}
			else if(s.equals("back"))
			{
				bw.write(back()+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		
	}
	public static int front()
	{
		if(empty() ==1)
		{
			return -1;
		}
		return queue[front];
	}
	public static int back()
	{
		if(empty() ==1)
		{
			return -1;
		}
		return queue[back-1];
	}
	public static void push(int i)
	{
		queue[back++] = i;
	}
	public static int pop()
	{	
		if(empty() == 1)
		{
			return -1;
		}
		front++;
		int i = queue[front -1];
		return i;
		
	}
	public static void reset()
	{
		if(front >back)
		{
			front = 0;
			back = -1;
		}
	}

	public static int empty()
	{
		if(size() == 0)
		{
			return 1 ;
		}
		else
		{
			return 0;
		}
		
	}	
	public static int size()
	{
		return back - front;
	}

}
