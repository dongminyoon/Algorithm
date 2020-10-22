package BruteForce;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        if (yellow == 1) return new int[] {3, 3};
        return searchPair(brown, yellow);
    }

    public int[] searchPair(int brown, int yellow) {
        // i는 행, j는 열
        for (int i = 1; i <= yellow/2; i++) {
            for (int j = i; j <= yellow; j++) {
                if (i * j != yellow) continue;
                System.out.println(j + " " + i);
                if (2 * i + 2 * j + 4 == brown)
                    return new int[] {j+2, i+2};
            }
        }

        return new int[] {0, 0};
    }
}
