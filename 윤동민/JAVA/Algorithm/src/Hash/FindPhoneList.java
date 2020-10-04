package Hash;

import java.io.IOException;

public class FindPhoneList {
    public static void main(String[] args) throws IOException {
        String[] sample = {"111113", "1112", "12"};

        System.out.println(solution(sample));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if (phone_book[i].length() > phone_book[j].length() || i == j) { continue; }
                for(int k = 0; k < phone_book[i].length(); k++) {
                    if (phone_book[i].charAt(k) == phone_book[j].charAt(k)) {
                        if (k == phone_book[i].length()-1) { return false; }
                        continue;
                    } else {
                        break;
                    }
                }

            }
        }

        return answer;
    }
}
