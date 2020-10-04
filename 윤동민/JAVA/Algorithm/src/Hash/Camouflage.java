package Hash;

import java.util.HashMap;

public class Camouflage {
    static HashMap<String, Integer> clothes_set = new HashMap<>();

    public static void main(String[] args) {
        String[][] sample = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        solution(sample);
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        for (int i = 0; i < clothes.length; i++) {
            if (clothes_set.get(clothes[i][1]) == null) {
                clothes_set.put(clothes[i][1], 1);
            } else {
                clothes_set.put(clothes[i][1], clothes_set.get(clothes[i][1]) + 1);
            }
        }

        for (String key : clothes_set.keySet()) {
            answer *= clothes_set.get(key) + 1;
        }

        return answer - 1;
    }
}
