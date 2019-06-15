package net.lzzy.algorithm;

import javax.xml.datatype.Duration;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
 public abstract class BaseSort <T extends Comparable<? super T>> {
    T[] items;
    long duration;
    private int compareCount;
    private int swapCount;
    int moveStep;

    private int swapMovie;
    BaseSort(T[]items){

    }

    public void sort(){
        long start = System.currentTimeMillis();
        for (int i=1;i<items.length;i++){
            int j = i-1;
            if (new T(items[i],items[j])){
                continue;
            }
            Integer tmp= (Integer) items[i];
            while (!(!(j >= 0) || !new T(items[j], tmp))){
                items[j+1]=items[j];
                moveStep++;
                j--;
            }
            items[j+i]= (T) tmp;
        }
        duration=System.currentTimeMillis()-start;
    }

    public abstract String getResult();

}
