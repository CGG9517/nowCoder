package interveiw.sort;

import java.util.Comparator;

/**
 * @Class: BubbleSorter
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/5
 */
public class BubbleSorter implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort( T[] a ) {
        /*
         * 冒泡算法
         */
        boolean swapped = true;
        for (int i = 1, len = a.length; i < len && swapped; i++)
        {
            swapped = false;
            for (int j = 0; j < len - i; j++)
            {
                if (a[j].compareTo(a[j+1]) > 0){
                    T temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sort( T[] a, Comparator<T> comparator ) {
        /*
         * 冒泡算法
         */
        boolean swapped = true;
        for (int i = 1, len = a.length; i < len && swapped; i++)
        {
            swapped = false;
            for (int j = 0; j < len - i; j++)
            {
                if (comparator.compare(a[j], a[j+1]) > 0){
                    T temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
