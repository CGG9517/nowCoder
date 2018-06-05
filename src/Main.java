

import java.util.*;

public class Main{
    public static void main(String[] args){
//        solution();solution
        Permutation("a");
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str != null){
            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if (str.indexOf(c) == i){
                    String string = "";
                    String sub = str.substring(0, i) + str.substring(i+1);
                    string += c;

                    ArrayList<String> subs = Permutation(sub);
                    if (subs.size() == 0) result.add(string);
                    else {
                        for (String s:subs)
                            result.add(string + s);
                    }
                }

            }
        }
        return result;
    }
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer>[] x = new ArrayList[4];

        for (int i = 0; i < 4; i++){
            x[i] = new ArrayList<>();
            for (int j = 0; j < n; j++){
                x[i].add(scanner.nextInt());
            }
        }
        int result = 1;
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        xs.addAll(x[0]);
        ys.addAll(x[1]);
        xs.addAll(x[2]);
        ys.addAll(x[3]);

        // 交点坐标一定是某个横坐标，某个纵坐标
        for (int i:xs){
            for (int j:ys) {
                int count = 0;
                for (int p = 0; p < n; p++){
                    if (i > x[0].get(p) && i <= x[2].get(p)
                            && j > x[1].get(p) && j <= x[3].get(p))
                        count++;
                }
                if (result < count) result = count;
            }
        }
        System.out.println(result);
    }
}