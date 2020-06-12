import java.io.IOException;

public class friends4block {

	static int check [][];
	public static void main(String[] args) throws IOException {
		int m = 6; 
		int n = 6;
		String board [] = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		int answer = solution(m,n,board);
		System.out.println(answer+"\n");
	}
	public static int solution(int m, int n , String[] board)
	{
		int answer =0;
		int count =0;
		char map [][] = new char [m][n];
		for(int i =0 ; i<m ; i++)
		{
				map[i] = board[i].toCharArray();
	
			
		}   
		boolean flag = false;
		
		do
		{
			flag = false;
			System.out.println("count: "+count++);
			for(int i =0 ; i<m-1 ; i++)
			{
				for(int j =0 ; j<n-1 ; j++)
					
				{
					if(map[i][j]!=' '&& !charCmp(map[i][j],map[i][j+1]) && !charCmp(map[i][j], map[i+1][j]) && !charCmp(map[i][j],map[i+1][j+1]))
					{
						if(map[i][j]>='A' && map[i][j]<='Z') {
							map [i][j] =(char) (map[i][j]+32);
							answer ++;
						}
						
						if(map[i][j+1]>='A' && map[i][j+1]<='Z') {
							map [i][j+1] =(char) (map[i][j+1]+32);
							answer ++;
						}
						
						if(map[i+1][j]>='A' && map[i+1][j]<='Z') {
							map [i+1][j] =(char) (map[i+1][j]+32);
							answer ++;
						}
						
						if(map[i+1][j+1]>='A' && map[i+1][j+1]<='Z') {
							map [i+1][j+1] =(char) (map[i+1][j+1]+32);
							answer ++;
						}
						flag = true;
					}
					
					
				}
			}
		
			if(flag)
			{
				for(int i =0 ; i<n ; i++)
				{
					for(int j =m-2 ; j>=0; j--)
					{
						for(int k =j ; k<m-1 ; k++)
						{
							if(map[k+1][i] == ' ' || map[k+1][i]>='a')
							{
								map[k+1][i] = map[k][i];
								map[k][i] = ' ';
							}
							
						}
					}
				}
			}
			for(int i =0 ; i<m ; i++)
			{
				for(int j=0 ; j<n ;j++)
				{
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}while(flag);
		
	
		
		return answer;
	}
	static boolean charCmp(char a, char b)
	{
		//대문자인 경우
		if(a>='A' && a<='Z' && b>='A' && b<='Z' && a ==b ) return false;
		//a는 대문자 b는 소문자인 경우 
		if(a>='A' && a<='Z' && b>='a' && b<='z' && a == (b-32)) return false;
		//b는 대문자 a는 소문자인 경우
		if(b>='A' && b<='Z' && a>='a' && a<='z' && b == (a-32)) return false;
		//소문자인 경우 
		if(a>='a' && a<='z' && b>='a' && b<='z' && a ==b ) return false;
		
		return true;
		
		
	}
	
}
