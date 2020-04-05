### 큐(Queue)

먼저 집어 넣은 데이터가 먼저 나오는 선입선출 FIFO(First In First Out) 구조의 자료구조





📒**큐(Queue)의 연산**

- push(data) : data를 큐에 넣음
- pop() : 큐에서 front 에 있는 정수를 빼고 출력(만약 정수 없는경우 -1 리턴)
- size() : back - front 로 큐의 배열 사이즈 리턴
- empty() : 큐가 비어있는지 확인 (비어있으면 1, 아니면 0) 
- front() : 큐의 가장 앞에 있는 정수 출력 (만약 정수 없는 경우 -1 리턴)
- back() : 큐의 가장 뒤에 있는 정수 출력(만약 정수없는 경우 -1 리턴)



📒**큐(Queue) 예제**

<img src="https://t1.daumcdn.net/cfile/tistory/25757B4556384E322B" alt="img" style="zoom:150%;" />





**📒큐(Queue) 코드**

​	➡️ 배열 이용 (큐의 배열의 크기 10000으로 지정)

~~~java
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
~~~



**front 함수**

~~~java
public static int front()
	{
		if(empty() ==1)
		{
			return -1;
		}
		return queue[front];
	}
~~~



**back 함수**

~~~java
public static int back()
	{
		if(empty() ==1)
		{
			return -1;
		}
		return queue[back-1];
	}
~~~



**push 함수**

~~~java
public static void push(int i)
	{
		queue[back++] = i;
	}
~~~



**pop 함수**

~~~java
public static int pop()
	{	
		if(empty() == 1)
		{
			return -1;
		}
		return queue[++front -1];
		
	}
~~~



**empty 함수**

~~~java
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
~~~



**size 함수**

~~~java
	public static int size()
	{
		return back - front;
	}
~~~

