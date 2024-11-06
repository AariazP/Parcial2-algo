package dinamica;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parenthesis {

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        List<String> res = new ArrayList<>();
        p.recurse(res, 0, 0, "", 3);
        System.out.println(res);
    }

    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }

        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }



}
