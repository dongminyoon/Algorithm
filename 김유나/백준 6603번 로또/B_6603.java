import java.io.*;
import java.util.StringTokenizer;

public class B_6603 {
	static boolean [] check = new boolean[6];
	static int [] num;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));


		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0 ) break;
		
			int S[] = new int[k];
			check = new boolean [k];
			num = new int[k];
			for(int i  = 0 ; i<k ; i++)
			{
				S[i] = Integer.parseInt(st.nextToken());
				
			}
			go(0,0,k, S);
			bw.write("\n");
			bw.flush();
			
		}
		bw.close();

	}
	static void go(int index, int start, int m, int S[]) throws IOException
	{
		if(index == 6)
		{
			for(int i =0 ;i<=5; i++)
			{
				bw.write(num[i]+" ");
			}
			bw.write("\n");
			
			return ;
		}
		for(int i = start; i<m ; i++)
		{
			if(check[i]) continue;
			num[index] = S[i];
			check[i] = true;
			go(index+1, i+1, m, S);
			check[i] = false;
		}
			
		
	}

}
