package net.lzzy.algorithm;

import android.graphics.Movie;
import android.nfc.FormatException;

import java.util.TimerTask;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public  class InsetSirt<T extends Comparable<? super T>>extends BaseSort<T>{
    InsetSirt(T[] items) {
        super(items);
    }
    @Override
    void sort(){
        for (int i=1;i<items.length;i++){
            int j=i-1;
            if (bigger(items[i],items[j])){
                continue;
            }
            T num=(T)items[i];
            while (j>=0&&bigger(items[j],num)){
                items[j+1]=items[j];
                moveStep++;
                j++;
            }
            items[j+1]=num;
        }
       // duration=System.currentTimeMillis();
    }
}
