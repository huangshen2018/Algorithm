package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public  abstract class BaseSearch <T extends Comparable<? super T>> {


    T[] items;
    private long duration;
    private int compareCount;
    private int swapCount;
    int moveStep;
    //endregion
    BaseSearch(T[] items) {
        this.items = items;
        compareCount = 0;
        swapCount = 0;
        moveStep = 0;
    }
    boolean equal(T a,T b){
        compareCount++;
        return  a.compareTo(b)==0;
    }

    int compare (T a,T b){
        compareCount++;
        return a.compareTo(b);
    }
    abstract int search(T key);
    protected BaseSearch(){

    }
    public long getDuration(){
        return duration;
    }
    public void setDuration(long duration){
        this.duration=duration;
    }
    public int getCompareCount(){
        return swapCount;
    }
    public void setCompareCount(int compareCount){
        this.compareCount=compareCount;
    }
     public int getSwapCount(){
        return
     }





    boolean bigger(T a, T b) {
        compareCount++;
        return a.compareTo(b) > 0;
    }

    void swap(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public String getResult(){
        String display = "";
        for (T i : items) {
            display = display.concat(i + ",");
        }
        return display.substring(0,display.length()-1);
    }

    public void sortWithTime(){
        long start = System.currentTimeMillis();
        sort();
        duration = System.currentTimeMillis() - start;
    }

}

