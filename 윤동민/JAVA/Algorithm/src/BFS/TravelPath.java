package BFS;

import java.util.ArrayList;
import java.util.Collections;

public class TravelPath {
    static String[][] staticTicket;
    static boolean[] isUseTicket;
    static ArrayList<String> allPath = new ArrayList<>();

    public static void main(String[] args) {
        solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
    }

    public static String[] solution(String[][] tickets) {
        String[] answer;

        staticTicket = tickets;
        isUseTicket = new boolean[tickets.length];



        for (int i = 0; i < staticTicket.length; i++) {
            if (staticTicket[i][0].equals("ICN")) {
                isUseTicket[i] = true;
                dfs(staticTicket[i][1], "ICN" + " " + staticTicket[i][1] ,1);
                isUseTicket[i] = false;
            }
        }

        Collections.sort(allPath);

        answer = allPath.get(0).split(" ");

        return answer;
    }

    public static void dfs(String curCity, String curPath, int ticketCount) {
        if (ticketCount == staticTicket.length) {
            allPath.add(curPath);
            return;
        }

        for (int i = 0; i < staticTicket.length; i++) {
            if (!isUseTicket[i] && curCity.equals(staticTicket[i][0])) {
                isUseTicket[i] = true;
                dfs(staticTicket[i][1], curPath + " " + staticTicket[i][1], ticketCount+1);
                isUseTicket[i] = false;
            }
        }
    }
}
