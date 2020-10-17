package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class WordConverter {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        for (int i = 0; i < words.length; i++) {
            if (!target.equals(words[i])) continue;
            else {
                answer = search(begin, target, words);
                break;
            }
        }

        return answer;
    }

    public static int search(String curWord, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Word(curWord, 0));

        while (!queue.isEmpty()) {
            Word tempWord = queue.poll();

            for (int i = 0; i < words.length; i++) {
                if (isDiffer(tempWord.word, words[i]) && !visited[i]) {
                    if (words[i].equals(target)) {
                        return tempWord.convertNumber+1;
                    }
                    visited[i] = true;
                    queue.offer(new Word(words[i], tempWord.convertNumber+1));
                }
            }
        }

        return 0;
    }

    public static boolean isDiffer(String start, String dest) {
        int differCount = 0;

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == dest.charAt(i)) continue;
            differCount++;
        }

        return differCount == 1;
    }
}

class Word {
    String word;
    int convertNumber;

    Word(String word, int convertNumber) {
        this.word = word;
        this.convertNumber = convertNumber;
    }
}
