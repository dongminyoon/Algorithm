import java.io.*;

public class backjoon1427_quicksort {
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
		

		quickSort(n, 0, size-1 );
		
		
		for(int j = 0; j<size ; j++)
		{
			bw.write(String.valueOf(n[j]));	
		}
		
		bw.flush();
		bw.close();
		
	}
	static void quickSort(int [] n , int left, int right)
	{
		if(left<right)
		{
			int p = partition(n, left, right);
			quickSort(n, left,p-1);
			quickSort(n, p+1, right);
		}
		
	}
	static int partition(int[] n,int left, int right)
	{
		pivot = left;
		int low = left;
		int high = right ; 
		int temp;
		
		while(low < high)
		{
			while((n[pivot]>n[low]) && (low<=high))
			{
				low ++;	
			}
			
			while((n[pivot]<n[high]) && (low<=high))
			{
				high --;
			}
			
			if(low<=high)
			{
				temp = n[high];
				n[high] = n[low];
				n[low] = temp;
			}
		
		}
		
			temp = n[pivot];
			n[pivot] = n[high];
			n[high] = temp;
			
			return high;

	}
}
