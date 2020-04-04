### 퀵 정렬(Quick Sort)

오름차순을 기준으로 정렬하고 분할 정복 알고리즘의 하나로, 평균적 매우 빠른 수행 속도를 갖는다. 

리스트 안에 한 요소(Pivot)를 선택 하여, 피벗을 기준으로 작은 요소는 모두 피벗의 왼쪽에 위치하고 피벗보다 큰 요소들은 피벗의 오른쪽으로 옮겨 정렬하는 방식

➡️ 기준값에 의한 분할을 통한 정렬법



📒**퀵정렬(Quick Sort) 장점**

	- 기준값에 의한 분할을 통한 정렬법으로 분할 과정에서 logN 이라는 시간이 걸리게 되고,
		시간 복잡도가 O(NlogN)으로 실행시간이 짧다
	- 추가 메모리 공간을 필요로 하지 않는다. (O(logN)만큼의 메모리만 필요로 함)

**📒퀵정렬(Quick Sort) 단점**

	- 정렬된 리스트에 대해 퀵정렬의 불균형 분할에 의해 오히려 수행시간 오래걸린다.
	- 기준값(Pivot)에 따라 시간복잡도가 크게 달라진다. 
		최악일 경우 O(n^2)이라는 시간복잡도를 갖게 된다.



**📒퀵정렬(Quick Sort) 시간 복잡도**

***최선의 경우***

 - 순환 호출의 깊이 - logN
 - 각 순환 호출 단계의 비교 연산 - 평균 n번
 - 순환 호출의 깊이* 각 순환 호출 단계의 비교연산 = NlogN
 - T(n) = O(nlogn) 

***최악의 경우***

	- 순환 호출의 깊이 - N 
	- 각 순환 호출 단계의 비교 연산 - 평균 n번
	- 순환 호출의 깊이*각 순환 호출 단계의 비교연산 = N^2
	- T(n) = O(n^2)

***평균***

 - T(n) = O(nlogn)





📒**퀵정렬(Quick Sort) 예제**

![img](https://gmlwjd9405.github.io/images/algorithm-quick-sort/quick-sort2.png)





**📒퀵정렬(Quick Sort) 코드**

​	➡️ 오름차순 기준 정렬 되어짐

~~~java
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

~~~

