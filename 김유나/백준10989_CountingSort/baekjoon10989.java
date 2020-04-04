import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon10989 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());
		int arr[] = new int[10001];
		for(int i = 0 ; i< n ; i++)
		{
			arr[Integer.parseInt(bf.readLine())]++;
		}
		for(int i = 1 ; i<10001 ; i++)
		{
			while(0<arr[i]--)
			{
				bw.write(Integer.toString(i)+"\n");
			}
		}
		
		bf.close();
		bw.close();
		
		
	}
}
