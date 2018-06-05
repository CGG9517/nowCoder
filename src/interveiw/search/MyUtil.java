package interveiw.search;

/**
 * @Class: BinarySearch
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/5
 */
public class MyUtil {
    /*
     * 迭代查找
     */
    public static <T extends Comparable<T>> int binarySearch(T[] a, T key)
    {
        int low = 0;
        int high = a.length - 1;
        while (low <= high)
        {
            /*
             * 加法可能导致整数越界，>>> 是不带符号向右位移， 因此不怕为负
             * 另一种方式：int mid = low + (( high - low) >> 1);
             */


            int mid = (low + high) >>> 1;
            if (key.compareTo(a[mid]) < 0)
            {
                high = mid - 1;
            }
            else if (key.compareTo(a[mid]) > 0)
            {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;  // 代表未找到
    }

    /*
     * 递归
     */
    public static <T extends Comparable<T>> int binarySearch(T[] a, int low, int high, T key){

        if (low <= high){
            int mid = (low + high) >>> 1;
            if (key.compareTo(a[mid]) < 0)
            {
                return binarySearch(a, 0, mid - 1, key);
            }
            else if (key.compareTo(a[mid]) > 0)
            {
                return binarySearch(a, mid + 1, high, key);
            }
            else {
                return mid;
            }
        }

        return -1;
    }

}
