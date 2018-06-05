import org.apache.commons.compress.utils.Lists;

import java.util.*;

/**
 * @class: FindJob
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/5/5
 */
public class FindJob {

    public static void main(String[] args) {
        getLantern();
       /* Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, Integer> Difficulty_MaxPay = new HashMap<>();
        List<Integer> dis = new ArrayList<>();
        for (int i = 0; i < n; i++){
           int di = scanner.nextInt();
           int pi = scanner.nextInt();
           // 查看是否存在
            if (Difficulty_MaxPay.containsKey(di)){
                if (i > Difficulty_MaxPay.get(di))
                    Difficulty_MaxPay.put(di,pi);
            }
            else {
                dis.add(di);
                Difficulty_MaxPay.put(di,pi);
            }
        }

    // 排序
        Collections.sort(dis);

        for (int i = 0; i < m; i++){
        int maxPay = 0;
        int ai = scanner.nextInt();
        for (int j = 0; j < dis.size(); j++)
        {
            int di = dis.get(j);
            if (di > ai) break;
            int pi = Difficulty_MaxPay.get(di);
            if (pi > maxPay)
                maxPay = pi;
        }
        System.out.println(maxPay);
    }*/



}


public static void getLantern(){
        Scanner scanner =new Scanner(System.in);
        int t = scanner.nextInt();
        int[] lanterns = new int[t];

        int x = Integer.MAX_VALUE;


        for (int i = 0; i < t; i++)
        {
            int length = scanner.nextInt();
            String street;
            street = scanner.next();

            int lanternCount = 0;
            for (int j = 0; j < length;)
            {
                char c = street.charAt(j);
                if (c == '.'){
                    lanternCount++;
                    j += 3;
                }
                else if (c == 'X'){
                    j++;
                }
            }
            lanterns[i] = lanternCount;
        }

        for(int i:lanterns)
            System.out.println(i);
}

    public static void getDirection(){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String[] turn = scanner.next().split("");

        int initialD = 0;
        for (String s:turn){
            if (s.equals("L")) initialD--;
            if (s.equals("R")) initialD++;
        }
        while (initialD < 0){
            initialD += 4;
        }

        // 最后的结果
        int r = initialD % 4;
        if (r == 0)
            System.out.println("N");
        else if (r == 1)
            System.out.println("E");
        else if (r == 2)
            System.out.println("S");
        else System.out.println("W");
    }

    public void leastGetup(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] clocks = new int[n][2];
        for (int i = 0; i<n; i++)
        {
            int h = scanner.nextInt();
            int m = scanner.nextInt();
            clocks[i][0] = h;
            clocks[i][1] = m;
        }

        int toClassroom = scanner.nextInt();

        int classH = scanner.nextInt();
        int classM = scanner.nextInt();

        int leastH = classH - toClassroom / 60;
        int leastM = classM - toClassroom % 60;

    }







    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 =  scanner.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        FindJob findJob = new FindJob();
        findJob.findBestPayment(m, n, scanner);

    }*/

    public void findBestPayment(int m, int n, Scanner scanner){
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++){
            String[] input2 = scanner.nextLine().split(" ");
            jobs[i] = new Job(Integer.parseInt(input2[0]),Integer.parseInt(input2[1]));
        }
        Arrays.sort(jobs);

        // 输入个人能力值
        int[] a = new int[m];
        String[] input3 = scanner.nextLine().split(" ");
        for (int i = 0; i < m; i++)
            a[i] = Integer.parseInt(input3[i]);

        int[] maxPay = new int[m];
        int j = 0;
        for (int ai : a){
            int MaxPay = Integer.MIN_VALUE;
            for (int i = 0; i < jobs.length; i++){
                Job job = jobs[i];
                if (ai < job.getDifficulty())
                    break;
                if (MaxPay < job.getPayment())
                    MaxPay = job.getPayment();

            }
            maxPay[j++] = MaxPay;
            System.out.println(MaxPay);
        }
        scanner.close();
    }



}

class Job implements Comparable<Job>{
    private int difficulty;
    private int payment;

    public Job(int difficulty, int payment) {
        this.difficulty = difficulty;
        this.payment = payment;
    }

    @Override
    public int compareTo(Job o) {
        int value = -1;
        // 先按能力值排序，再按收入排序
        if (this.getDifficulty() < o.difficulty)
            value = -1;
        else if (this.getDifficulty() == o.difficulty){
            if (this.getPayment() < o.getPayment())
                value = -1;
            if (this.getPayment() == o.getPayment())
                value = 0;
            if (this.getPayment() > o.getPayment())
                value = 1;
        }
        else value = 1;
        return value;
    }

    public int getDifficulty() {
        return difficulty;
    }
    public int getPayment() {
        return payment;
    }
}
