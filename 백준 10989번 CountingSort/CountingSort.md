## Counting Sort

***Counting Sort***

👉 일반적으로 O(NlonN) **Quick Sort**, **Merge Sort**가 가장 빠르다. O(n)의 **Counting Sort**가 더 빠른 동작을 할 수 있다. 그러나 동작 원리를 보면 왜 **Quick Sort**, **Merge Sort**을 사용하는지 알 수 있다.

 **Counting Sort**는 각 숫자가 몇 번 나오는지 세어준다. 그렇기 때문에, 만약 수열에서 뜬금없이 큰 수가 나오게 되면 그 숫자까지의 무의미한 시간을 낭비하게 된다.

<br>

***단점***

👉 일반적으로 O(n)이라는 빠른 시간을 자랑하지만, 갑자기 한 숫자가 커질 경우 무의미안 반복으로 시간을 낭비할 수 있다.

<br>

***시간복잡도***

 N인 배열이 있다. 그렇다면 N만큼 반복하면서 각 숫자의 개수를 세어주고 그 숫자만큼 반복하면서 다시 출력을 해주면 된다.

 그렇기 때문에, **O(n)**의 복잡도를 가지게 된다.

<br>

***방법***

1️⃣ 배열의 최대 수를 구한다.

2️⃣ 그 배열의 최대 수까지 반복을 실행하며 각 숫자별 **Counting**을 실행한다.

3️⃣ 이후 **Counting**을 실행한만큼 배열에 새롭게 저장해주고 출력한다.

<br>

***소스코드(JAVA)***

```java
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  int size = Integer.parseInt(br.readLine());
  int[] countingArray = new int[10001];

  int max = 0;
  int temp;
  for(int i = 0; i < size; i++) {
    temp = Integer.parseInt(br.readLine());
    countingArray[temp]++;
    if (temp > max) max = temp;
  }

  for(int i = 0; i <= max; i++) {
    for(int j = 0; j < countingArray[i]; j++) {
      bw.write( Integer.toString(i) + "\n");
    }
  }

  bw.flush();
  bw.close();
}
```



