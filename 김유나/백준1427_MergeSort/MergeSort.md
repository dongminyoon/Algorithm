### 합병 정렬(Merge Sort)

배열을 반으로 분할해가면서 정렬하는 알고리즘으로 퀵 정렬과 다르게 Pivot을 설정하지 않고 무조건 절반으로 분할하여 각각의 원소로 나눠질때 병합하는 방식 (분할정복법 이용)

➡️ 전체 원소를 하나의 단위로 분할한 후 분할한 원소를 다시 병합하는 방식이다.



***분할정복법(Divide-And-Conquer)이란?***

1. 분할: 해결하고자하는 문제를 작은 크기의 동일한 문제로 분할
2. 정복: 각각의 작은 문제를 순환적으로 해결
3. 합병: 작은 문제의 해를 합하여 원래 문제에 대한 해를 구함



📒**합병 정렬(Merge Sort) 장점**

	- 항상 시간복잡도가 O(NlogN)으로 빠른 편이다.

**📒합병 정렬(Merge Sort) 단점**

	- 추가적인 메모리 공간이 필요하다.



**📒합병 정렬(Merge Sort)시간 복잡도**

 - 분할 단계 ) 비교연산과 이동연산 수행 xxx
 - 순환 호출의 깊이 (합병 단계의 수) : logN
 - 각 합병단계의 비교 연산 : 최대 N번
 - 순환 호출의 깊이 만큼의 합병 단계* 각 합병 단계의 비교연산 = NlogN
 - T(n) = O(nlogn)



📒**합병 정렬(Merge Sort) 예제**

![img](https://gmlwjd9405.github.io/images/algorithm-merge-sort/merge-sort-concepts.png)





**📒합병 정렬(Merge Sort) 코드**

​	➡️ 오름차순으로 정렬되어짐

~~~java
static void mergesort(int left, int right)
	{
		int mid ; 
		mid = (left + right) /2;
		
		if(left<right)
		{
			mergesort(left,mid);
			mergesort(mid+1, right);
			merge(left,mid,right);
		}
		
	}
	static void merge(int left, int mid, int right)
	{
		int i= left ; 
		int l = left;
		int j = mid+1;
		int [] sort = new int[n.length];
		
		while(i<= mid && j<= right)
		{
			if(n[i]<n[j])
			{
				sort[l++] = n[i++];
			}
			else
			{
				sort[l++] = n[j++];
			}
		}
		
		if(i>=mid)
		{
			for(int q = j ; q<=right ; q++)
			{
				sort[l++] = n[q];
			}
		}
		if(j>=right)
		{
			for(int p = i ; p<=mid ; p++ )
			{
				sort[l++] = n[p];
			}
		}
		
		for(int q = left ; q<=right ; q++)
		{
			n[q] = sort[q];
		}
		
		
	}
~~~

