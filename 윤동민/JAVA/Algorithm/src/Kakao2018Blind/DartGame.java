package Kakao2018Blind;
import java.util.ArrayList;

public class DartGame {
    public static void main(String[] args) {
        int answer = solution("1D2S#10S");
        System.out.println(answer);
    }

    static public int solution(String dartResult) {
        int answer = 0;

        ArrayList<Integer> stack = new ArrayList<>();
        int[] temp = new int[2];

        for(int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case 'S':
                    break;
                case 'D':
                    temp[0] = stack.remove(stack.size()-1);
                    temp[0] *= temp[0];
                    stack.add(temp[0]);
                    temp[0] = 0;
                    break;
                case 'T':
                    int number = stack.remove(stack.size()-1);
                    temp[0] = number;
                    temp[0] *= number;
                    temp[0] *= number;
                    stack.add(temp[0]);
                    temp[0] = 0;
                    break;
                case '*':
                    if(stack.size() == 0) break;
                    else if(stack.size() == 1) {
                        temp[0] = stack.remove(stack.size()-1);
                        temp[0] *= 2;
                        stack.add(temp[0]);
                        temp[0] = 0;
                    } else {
                        temp[0] = stack.remove(stack.size()-1);
                        temp[0] *= 2;
                        temp[1] = stack.remove(stack.size()-1);
                        temp[1] *= 2;
                        stack.add(temp[0]);
                        stack.add(temp[1]);
                        temp[0] = 0;
                        temp[1] = 0;
                    }
                    break;
                case '#':
                    if(stack.size() == 0) break;
                    else {
                        temp[0]= stack.remove(stack.size()-1);
                        temp[0] *= -1;
                        stack.add(temp[0]);
                        temp[0] = 0;
                    }
                    break;
                default:
                    if(dartResult.charAt(i) - '0' == 1 && dartResult.charAt(i+1) - '0' == 0) {
                        stack.add(10);
                        i++;
                    } else stack.add(dartResult.charAt(i) - '0');
                    break;
            }
        }


        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }
}
