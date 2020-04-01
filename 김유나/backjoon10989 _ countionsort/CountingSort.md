### 계수 정렬(Counting Sort)

각 숫자가 몇개 있는지 갯수를 세어서 배열에 저장한 후 정렬하는 알고리즘

➡️ 각 숫자가 몇번 나왔는지 세어주는 방식



📒**계수 정렬(Counting Sort) 장점**

	- 시간복잡도가 O(n)으로 엄청 빠르다(가장 빠른 정렬 알고리즘)

**📒계수 정렬(Counting Sort) 단점**

	- 대부분의 상황에서 엄청난 메모리 낭비를 야기한다 (미리 배열의 크기를 10001로 지정하기 때문에)



**📒계수 정렬(Counting Sort) 시간 복잡도**

 - T(n) = O(n)



📒**계수 정렬(Counting Sort) 예제**

![Crocus](https://t1.daumcdn.net/cfile/tistory/21716D3A5809DD9A0E)

**📒계수 정렬(Counting Sort) 코드**

​	➡️ 각각의 숫자의 배열 자리에 숫자가 들어온 개수만큼 counting 되어짐

~~~java
//배열에 숫자의 개수만큼 counting 하는 과정		
for(int i = 0 ; i< n ; i++)
		{
			arr[Integer.parseInt(bf.readLine())]++;
		}
//1부터 10000까지 숫자의 개수만큼 출력해나가는 과정
for(int i = 1 ; i<10001 ; i++)
		{
			while(0<arr[i]--)
			{
				bw.write(Integer.toString(i)+"\n");
			}
		}		
~~~

