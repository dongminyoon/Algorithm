import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderCount = Integer.parseInt(br.readLine());

        String[] orders = new String[orderCount];

        for(int i = 0; i < orderCount; i++) orders[i] = br.readLine();

        main.excuteOrders(orders);

    }

    static void excuteOrders(String[] orders) {
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < orders.length; i++) {
            String[] order = orders[i].split(" ");
            if(order[0].equals("push")) {
                queue.add(0, Integer.parseInt(order[1]));
            } else if(order[0].equals("pop")) {
                if(queue.isEmpty()) System.out.println("-1");
                else System.out.println(queue.remove(queue.size()-1));
            } else if(order[0].equals("size")) {
                System.out.println(queue.size());
            } else if(order[0].equals("empty")) {
                if(queue.isEmpty()) System.out.println("1");
                else System.out.println("0");
            } else if(order[0].equals("front")) {
                if(queue.isEmpty()) System.out.println("-1");
                else System.out.println(queue.get(queue.size()-1));
            } else {
                if(queue.isEmpty()) System.out.println("-1");
                else System.out.println(queue.get(0));
            }
        }
    }
}
