import java.io.*;

public class secretmap {

	public static void main(String[] args) throws IOException {

		int arr1[] = {9,20,28,18,11};
		int arr2[] = {30,1,21,17,28};
		
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String sarr1[] = new String[n];
		String sarr2[] = new String[n];
		String answer[] = new String[n];
		String a ;
		
		for(int i = 0 ; i<n; i++)
		{
			
			sarr1[i] = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr1[i]).toString()));
			sarr2[i] = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr2[i]).toString()));
		}
		
		bw.write("[");
		for(int i = 0 ; i< n ; i++)
		{
			answer[i]="";
			for(int j = 0 ; j<5 ; j++)
			{
				if(sarr1[i].charAt(j)=='1' || sarr2[i].charAt(j)=='1')
				{
					a = "#";
					//bw.write(a+"\n");
				}
				else
				{
					a =" ";
				}
				answer[i] = answer[i].concat(a);
				
			}
			bw.write("\""+answer[i]+"\"");
			if(i!=n-1)
			{
				bw.write(", ");
			}
		}	
		bw.write("]");
		bw.flush();
		bw.close();
		
	
	}
	
}
