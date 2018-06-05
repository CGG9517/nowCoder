package interveiw.sort;

import java.util.Comparator;

/**
 * @Class: Sorter
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/5
 */
public interface Sorter {
    <T extends Comparable<T>> void sort(T[] a);
    <T extends Comparable<T>> void sort(T[] a, Comparator<T> comparator );
}
