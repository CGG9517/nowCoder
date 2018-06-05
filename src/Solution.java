import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Class: Solution
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/5/25
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        /*
         使用最大堆保存
        */

        int length = input.length;
        if (k == 0){return result;}

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < length; i++)
        {
            if (maxHeap.size() < k)
                maxHeap.offer(input[i]);
            else if (maxHeap.peek() > input[i])
            {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        Arrays.copyOfRange(input, 0, 2);

        for (Integer i : maxHeap)
        {
            result.add(i);
        }
        return result;
    }
}
