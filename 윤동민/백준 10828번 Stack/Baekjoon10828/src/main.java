import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int orderCount = Integer.parseInt(br.readLine());
        String[] order = new String[orderCount];

        for(int i = 0; i < orderCount; i++) {
            order[i] = br.readLine();
        }
        main.excuteOrders(order);
    }

    static void excuteOrders(String[] orders) {
        ArrayList<Integer> stack = new ArrayList<>();

        for(int i = 0; i < orders.length; i++) {
            String[] order = orders[i].split(" ");
            if(order[0].equals("push")) {
                stack.add(Integer.parseInt(order[1]));
            } else if (order[0].equals("pop")) {
                if(stack.size() == 0) System.out.println("-1");
                else System.out.println(stack.remove(stack.size()-1));
            } else if (order[0].equals("size")) {
                System.out.println(stack.size());
            } else if (order[0].equals("empty")) {
                if(stack.isEmpty()) System.out.println("1");
                else System.out.println("0");
            } else {
                if(stack.isEmpty()) System.out.println("-1");
                else System.out.println(stack.get(stack.size()-1));
            }
        }
    }
}
