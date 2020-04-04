### 스택(Stack)

한 쪽에서 자료를 넣고 빼는 LIFO(Last In First Out)형식의 자료구조

➡️ 가장 최근에 스택에 추가한 항목이 가장 먼저 제거됨



📒**스택(Stack)의 연산**

- pop() : 스택에서 가장 위에 있는 항목 제거 (만약 데이터가 없으면 -1 리턴)
- push(data) : 스텍에 데이터를 가장 윗 부분에 추가
- size() : 스택의 사이즈 
- empty() : 스택이 비어있는지 아닌지 판단
- top() : 스택에 가장 윗 부분에 존재하는 데이터 리턴 (만약 데이터 없으면 -1 리턴) 



📒**스택(Stack) 예제**



<img src="https://lh3.googleusercontent.com/proxy/ixJZpHcDPb9wssavT3BtfRgyqHqInpex-JkAuq8MHPGnsmU4fWtxR0m86zSElUXi8AYCXuudHZ2SocIeNML0_I5KVjQdBoQDTpFc_HIogaMBCvYRHJsKtic-NDcwTRmor4e24ZvRbFkIzjwrlAp9cXq8I2_v0sZSaGx2rZLpxRvAfGY51PzmqLOrHoRNlwZTbmyuBBm13e1sfva8Yc0IIhguvVR4av6ywvBNf_9E5QQx06-uCphcV0Zj6rHhy5f9mk1nq6mV3FYlDqlJR5ZDOEUkOxF0sAJ0_Zdlkpk" alt="JAVA - Stack(스택) - pop(), push() 만들기 : 네이버 블로그" style="zoom:150%;" />





**📒스택(Stack) 코드**

​	➡️ 배열 이용 (stack[]의 사이즈는 임의로 명령어 개수만큼 지정)

~~~java
public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		top = -1;
		
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
				bw.write(top+1+"\n");
			}
			else if(s.equals("empty"))
			{
				bw.write(empty()+"\n");
			}
			else if(s.equals("top"))
			{
				bw.write(top()+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		
	}
~~~



**push 함수**

~~~java
public static void push(int i)
	{
		stack[++top] = i;
	}
~~~



**pop 함수**

~~~java
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
~~~



**top 함수**

~~~java
public static int top()
	{
		if(top == -1 )
		{
			return -1;
		}
		else
		{
			return stack[top];	
		}	
	}
~~~



**empty 함수**

~~~java
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
~~~