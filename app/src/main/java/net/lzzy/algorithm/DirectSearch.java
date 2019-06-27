package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class DirectSearch <T extends Comparable<? super T>>extends BaseSort<T> {
    DirectSearch(T[] items) {
        super(items);
    }
   @Override
    public void sort(){
        for (int i = 0; i < items.length - 1; i++){
            int minPos = i;
            for (int j = i + 1; j < items.length; j++) {
                if (bigger(items[minPos],items[j])) {
                    minPos = j;

                }
            }
            swap(minPos, i);
        }
    }
}
