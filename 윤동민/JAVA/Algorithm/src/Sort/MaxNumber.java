package Sort;
import java.util.*;

public class MaxNumber {
    public String solution(int[] numbers) {
        String answer = "";

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++)
            list.add(Integer.toString(numbers[i]));


        Collections.sort(list, (o1, o2) -> {
            Integer new1 = Integer.parseInt(o1+o2);
            Integer new2 = Integer.parseInt(o2+o1);
            return new2.compareTo(new1);
        });

        if (list.get(0).equals("0")) return "0";

        for (int i = 0; i < list.size(); i++)
            answer += list.get(i);

        return answer;
    }
}
