import java.io.*;

public class backjoon1427_mergesort {
	static int n[] ; 
	static int pivot ;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = bf.readLine();
		int size = s.length();
		n = new int[size];
		int temp ;
		
		for(int i = 0 ; i<size ; i++){
			n[i] = s.charAt(i) - '0';
		}
		
		mergesort(0, size-1); 
		for(int j = 0; j<size ; j++)
		{
			bw.write(String.valueOf(n[j]));	
		}
		
		bw.flush();
		bw.close();
		
	}
	static void mergesort(int left, int right)
	{
		int mid ; 
		mid = (left + right) /2;
		
		if(left<right)
		{
			mergesort(left,mid);
			mergesort(mid+1, right);
			merge(left,mid,right);
		}
		
	}
	static void merge(int left, int mid, int right)
	{
		int i= left ; 
		int l = left;
		int j = mid+1;
		int [] sort = new int[n.length];
		
		while(i<= mid && j<= right)
		{
			if(n[i]<n[j])
			{
				sort[l++] = n[i++];
			}
			else
			{
				sort[l++] = n[j++];
			}
		}
		
		if(i>=mid)
		{
			for(int q = j ; q<=right ; q++)
			{
				sort[l++] = n[q];
			}
		}
		if(j>=right)
		{
			for(int p = i ; p<=mid ; p++ )
			{
				sort[l++] = n[p];
			}
		}
		
		for(int q = left ; q<=right ; q++)
		{
			n[q] = sort[q];
		}
		
		
	}
	
}
