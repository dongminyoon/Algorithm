import java.io.*;
import java.io.IOException;

public class baekjoon1427 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = bf.readLine();
		int size = s.length();
		int n_array[] = new int[size];
		int temp ;
		
		for(int i = 0 ; i<size ; i++){
			n_array[i] = s.charAt(i) - '0';
		}
		
		// 버블 소트 
		for(int i = 0 ; i<size ; i++)
		{
			for(int j = 0 ; j<size-1 ; j++)
			{
				if(n_array[j]>n_array[j+1])
				{
					temp = n_array[j];
					n_array[j] = n_array[j+1];
					n_array[j+1] = temp;
				}
			}
		}
		
		
		for(int j = size -1 ; j>=0 ; j--)
		{
			bw.write(String.valueOf(n_array[j]));	
		}
		
		bw.flush();
		bw.close();
		
		
		
		
	}

}
