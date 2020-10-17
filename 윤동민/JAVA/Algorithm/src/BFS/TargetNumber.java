package BFS;

public class TargetNumber {
    static int count = 0;
    static int targets;
    static int[] numberss;

    public static void main(String[] args) {
        solution(new int[] {1, 1, 1, 1, 1}, 3);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        numberss = numbers;
        targets = target;
        dfs(0, 0);

        System.out.println(count);
        return answer;
    }

    public static void dfs(int index, int total) {
        if (total == targets && index == numberss.length) {
            count++;
            return;
        }

        if (index == numberss.length) return;

        total += numberss[index];
        dfs(index+1, total);

        total -= 2 * numberss[index];
        dfs(index+1, total);
    }

}
