package simulation;

public class ConvertBlink {
    public String solution(String p) {
        if (p.length() == 0) return "";

        return dfs(p);
    }

    public String dfs(String p) {
        if (p.equals("")) { return ""; }
        String[] separated = separate(p);

        String u = separated[0];
        String v = separated[1];

        if (isComplete(u)) {
            return u + dfs(v);
        } else {
            String temp = "(";
            temp += dfs(v);
            temp += ")";

            if (u.length() > 2) {
                String sub = u.substring(1, u.length()-1);
                String new_u = "";
                for (int i = 0; i < sub.length(); i++) {
                    if (sub.charAt(i) == '(') {
                        new_u += String.valueOf(')');
                    } else {
                        new_u += String.valueOf('(');
                    }
                }

                temp += new_u;
            }
            return temp;
        }
    }

    public boolean isComplete(String str) {
        int left_count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left_count++;
            } else {
                if (left_count > 0) left_count--;
                else { return false; }
            }
        }

        if (left_count == 0) return true;
        else return false;
    }

    public String[] separate(String p) {
        int count_left = 0;
        int count_right = 0;

        String u = "";

        for (int i = 0; i < p.length(); i++) {
            char curChar = p.charAt(i);
            u += String.valueOf(curChar);

            if (p.charAt(i) == '(')
                count_left++;
            else
                count_right++;

            if (count_left != 0 &&
                    count_right != 0 &&
                    count_left == count_right) {
                break;
            }
        }

        String v = p.substring(count_left+count_right, p.length());
        return new String[] {u, v};
    }
}
