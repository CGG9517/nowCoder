/**
 * @Class: QuickSort
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/5/25
 */
public class QuickSort {
    private static final int CUTOFF = 7;
    private static <T extends Comparable<? super T>> void quickSelect(T[] a, int left, int right, int k)
    {
        if (left + CUTOFF <= right)
        {
            T pivot = median3(a, left, right);

            int i = left, j = right-1;
            for(;;)
            {
                while (a[++j].compareTo(pivot) < 0){}
                while (a[--j].compareTo(pivot) > 0){}
                if (i < j) swapReference(a, i, j);
                else break;
            }
            swapReference(a, i, right-1);

            if (k <= i) quickSelect(a, left, i-1, k);
            else if(k > i+1)
                quickSelect(a, i+1, right, k);
        }
        else
            insertionSort(a, left, right);
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {
        // 插入排序

        int j;
        for (int p = 1; p < a.length; p++)
        {
            T tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j-1]) < 0; j--)
            {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    private static <T extends Comparable<? super T>> void swapReference(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        if (a[left].compareTo(a[right]) > 0)
            swapReference(a, left, right);

        int center = (left + right)/2;
        if (a[center].compareTo(a[left]) < 0)
            swapReference(a, center, left);
        if (a[center].compareTo(a[right]) > 0)
            swapReference(a, center, right);

        swapReference(a, center, right-1);
        return a[right-1];
    }
}
