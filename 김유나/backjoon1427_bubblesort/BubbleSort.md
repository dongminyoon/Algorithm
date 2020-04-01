### 버블 정렬(Bubble Sort)

서로 인접한 두 원소를 검사하여 정렬하는 알고리즘 ( 선택 정렬과 기본 개념이 유사함)

➡️ 서로 인접한 두 원소를 검사하여 정렬하는 방식



📒**버블정렬(Bubble Sort) 장점**

	- 구현이 매우 간단 (인접한 값만 계속 비교하면 되는 방식)
	- 코드 자체가 직관적

**📒버블정렬(Bubble Sort) 단점**

	- 굉장히 비효율적 (시간복잡도 최악, 최선, 평균 모두 O(n^2))



**📒버블정렬(Bubble Sort) 시간 복잡도**

 - 비교 횟수 n-1,n-2,n-3, ...,2,1번 = n(n-1)/2
 - T(n) = O(n^2) 



📒**버블정렬(Bubble Sort) 예제**

![Screen Shot 2020-04-01 at 3.14.26 PM](/Users/kim-yuna/Library/Application Support/typora-user-images/Screen Shot 2020-04-01 at 3.14.26 PM.png)





**📒버블정렬(Bubble Sort) 코드**

​	➡️ 내림차순으로 정렬되어짐

~~~java
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

~~~

