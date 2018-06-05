import java.util.Arrays;

/**
 * @Class: Solution2
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/5/25
 */
public class Solution2 {

    // 保存最大值
    int maxSum = Integer.MIN_VALUE;


    public int FindGreatestSumOfSubArray(int[] array) {
        return findGreatSum(array, 0, array.length);
    }
    /**
     * @Description:
     * @param array
     * @param start 包含
     * @param end 不包含
     * @return: int
     * @Author: Jiang Chao
     * @Date: 2018/5/25
     * @Version: 1.0
     */
    public int findGreatSum(int[] array, int start, int end)
        {
            int sum = 0;

            for (int i = start; i < end; i++) {
                if (sum < 0) {
                    findGreatSum(array, i, end);
                    break;
                }
                sum += array[i];
                if (maxSum < sum) maxSum = sum;

            }
            return maxSum;
        }





    public static void main(String[] args) {
        int[] input = {6,-3,-2,7,-15,1,2,2};
        int a = new Solution2().FindGreatestSumOfSubArray(input);
        System.out.println(a);
    }

}
