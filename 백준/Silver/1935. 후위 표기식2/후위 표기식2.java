import java.io.*;
import java.util.*;
import java.util.Stack;

public class Main {
    static double calculate(double a, double b, String expr) {
        if (Objects.equals(expr, "+"))
            return a + b;
        else if (Objects.equals(expr, "-"))
            return a - b;
        else if (Objects.equals(expr, "*"))
            return a * b;
        else if (Objects.equals(expr, "/"))
            return a / b;

        return 0;
    }

    static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        Map<String, Integer> map = new LinkedHashMap<>();

        int N = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        String [] expr = new String[tmp.length()];

        for (int i = 0; i < expr.length; i++) {
            expr[i] = tmp.substring(i, i + 1);
        }

        int [] number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        for (String e: expr) {
            if (Character.isLetter(e.charAt(0))) {
                map.put(e, null);
            }
        }

        int index = 0;
        for (String key: map.keySet()) {
            map.put(key, number[index++]);
        }

        for (int i = 0; i < expr.length; i++) {
            if (Character.isLetter(expr[i].charAt(0))) {
                expr[i] = Integer.toString(map.get(expr[i]));
            }
        }

        for (String e: expr) {
            if (isNumeric(e)) {
                stack.push(Double.parseDouble(e));
            }
            else {
                if (stack.size() > 1) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(calculate(a, b, e));
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
