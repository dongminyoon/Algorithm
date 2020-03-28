## 병합정렬(Merge Sort)

***병합정렬***

👉 전체를 상대로 정렬을 수행하는 것이 아니라 **분할(divide)**한 뒤 각 부분집합들에 대해 정렬할 후 다시 **결합(combine)**하는 정렬이다.

<br>

***단점***

👉 추가적인 배열을 만들어야 한다.

👉 정렬한 레코드의 크기가 클 경우 시간적 낭비가 있다.

<br>

***시간복잡도***

 N개인 배열을 한번 분할하면 N/2, N/2 ➡️ 2가지가 생긴다.

 다시 분할하면 N/4, N/4, N/4, N/4 ➡️ 4가지가 생긴다.

 4의 크기를 가진 배열이 있다고 생각하면 1의 크기를 가진 배열로 쪼개기 위해서는 logN만큼을 반복하여야 한다. 그리고 쪼개진 만큼 **병합(Combine)**을 진행하여야하기 때문에 N만큼의 시간이 더 소요된다.

 즉 ***`NlogN`***의 시간복잡도를 가지게 된다.

<br>

***방법***

1️⃣ 정렬할 집합에서 최소 원소의 부분이 1개가 될 때까지 분할 작업을 반복한다. Ex 자료가 10개일 시 10개의 집합을 만든다.

2️⃣ 각 분할 작업을 진행한 배열끼리 비교를 진행하고 크기 순으로 합치는 과정을 반복한다.

<br>

***소스코드(JAVA)***

```java
public void mergeSort(int firstIndex, int lastIndex) {
  int middleIndex = (firstIndex + lastIndex) / 2;

  if(firstIndex < lastIndex) {
    mergeSort(firstIndex, middleIndex);
    mergeSort(middleIndex + 1, lastIndex);
    merge(firstIndex, middleIndex, lastIndex);
  }
}

public void merge(int firstIndex, int middleIndex, int lastIndex) {
  int i = firstIndex, k = firstIndex;
  int j = middleIndex + 1;
  int[] temp = new int[data.length];

  while (i <= middleIndex && j <= lastIndex) {
    if(data[i] >= data[j])
      temp[k++] = data[i++];
    else
      temp[k++] = data[j++];
  }

  while (i <= middleIndex)
    temp[k++] = data[i++];
  while (j <= lastIndex)
    temp[k++] = data[j++];

  for(int l = firstIndex; l <= lastIndex; l++)
    data[l] = temp[l];
}
```

