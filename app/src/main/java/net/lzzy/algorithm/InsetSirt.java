package net.lzzy.algorithm;

import android.graphics.Movie;
import android.nfc.FormatException;

import java.util.TimerTask;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public abstract class InsetSirt<T extends Comparable<? super T>>extends BaseSort   {
    InsetSirt(Comparable[] items) {
        super(items);
    }
    public void sort(){
        long start=System.currentTimeMillis();
        for (int i=1;i<items.length;i++){
            int j=i-1;
            if (items[j].compareTo(items[i])<0){
                continue;
            }
            T num=(T)items[i];
            while (j>=0&&items[j].compareTo(num)>0){
                items[j+1]=items[j];
                j--;
                moveStep++;
            }items[j+1]=num;
        }
        duration=System.currentTimeMillis();
    }
}
