package net.lzzy.algorithm;

import android.graphics.Movie;
import android.nfc.FormatException;

import java.util.TimerTask;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public class InsertSort  <T extends Comparable<? super T>>extends BaseSort<T> {

    public InsertSort(T[] items) {
        super(items);
    }

    //--
    @Override
    public void Sort() {

        for (int i = 1; i < items.length; i++) {
            int j = i - 1;
            if (bigger(items[i], items[j])) {
                continue;
            }
            T tmp = items[i];
            while (j >= 0 && bigger(items[j], tmp)) {
                items[j + 1] = items[j];
                movestep++;
                j--;
            }
            items[j + 1] = tmp;
        }

    }
}
