import java.io.*;

public class dartgame {
	public static void main(String[] args) throws IOException {
		int answer = solution("1D2S3T*");
		System.out.println(answer);
	}
	static public int solution(String dart)
	{
		int temp1 =0; // 점수
		int temp2 =0; //전 점
		int asterisk =0; // *
		int answer = 0;
		
		for(int i =0 ; i<dart.length() ; i++)
		{
			switch(dart.charAt(i))
			{
			case 'S' :
				if(i != dart.length()-1)
				{
					
				
				if(dart.charAt(i+1)=='*')
				{
					if(asterisk == 0)
					{
						asterisk ++;
						if(temp2!=0)
						{
							answer -= temp2;
							temp1 = temp2*2 + temp1*2;
						}
						else
						{
							temp1 = temp1*2;
						}
					}
					else
					{
						if(temp2!=0 && asterisk==1) {
							answer -= temp2;
							temp1 = temp2*2 + temp1*2;
						}
					}
					
				}
				
				if(dart.charAt(i+1)=='#')
				{
					temp1 = -temp1;
				}
				}
			//	System.out.println("S:"+temp1);
				temp2 = temp1;
				answer += temp1;
				temp1 =0;
			//	System.out.println(answer);
				break;
			case 'D' :
				temp1 = temp1*temp1;
				if(i != dart.length()-1)
				{
				
				if(dart.charAt(i+1)=='*')
				{
					if(asterisk == 0)
					{
						asterisk ++;
						if(temp2!=0)
						{
							answer -= temp2;
							temp1 = temp2*2 + temp1*2;
						}
						else
						{
							temp1 = temp1*2;
						}
					}
					else
					{
						if(temp2!=0 && asterisk==1) {
							answer -= temp2;
							temp1 = temp2*2 + temp1*2;
						}
						
					}
					
				}
				
				if(dart.charAt(i+1)=='#')
				{
					temp1 = -temp1;
				}
				}
				//System.out.println("D:"+temp1);
				temp2 = temp1;
				answer += temp1;
				temp1 =0;
				//System.out.println(answer);
				break;
			case 'T' :
				temp1 = temp1*temp1*temp1;
				if(i != dart.length()-1)
				{
				
				if(dart.charAt(i+1)=='*')
				{
					if(asterisk == 0)
					{
						asterisk ++;
						if(temp2!=0)
						{
							answer -= temp2;
							temp1 = temp2*2 + temp1*2;
							
						}
						else
						{
							temp1 = temp1*2;
						}
					}
					else
					{
						if(temp2!=0 && asterisk==1) {
							answer -= temp2;
							temp1 = temp2*2 + temp1*2;
						}
					}
					
				}
				
				if(dart.charAt(i+1)=='#')
				{
					temp1 = -temp1;
				}
				}
				//System.out.println("T:"+temp1);
				temp2 = temp1;
				answer += temp1;
				temp1 =0;
				//System.out.println(answer);
				break;
			case '*' : break;
			case '#' : break;
			default : 
				if(dart.charAt(i)-'0' == 1 && dart.charAt(i+1)-'0'==0)
				{
					temp1 = 10;
					//System.out.println("dart: "+temp1);
					
				}
				else
				{
					if(temp1==0)
					{
					temp1 = dart.charAt(i)-'0';
					//System.out.println("dart: "+temp1);
					}
				}
				break;
			}
		}
		
		return answer ;
		
	}
}

