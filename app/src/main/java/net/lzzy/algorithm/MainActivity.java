package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                //directSort();
                Damon sort=new Damon(items);
                String result=sort.getResult();
                Toast.makeText(this, "总时长",
                        Toast.LENGTH_SHORT).show();
                tvResult.setText(result);
                break;
//                insertsort();
//                displayItems(tvResult);
//                break;
            default:
                break;
        }
    }

    public void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    public void directSort() {
        //todo:直接选择排序的具体实现
        //分为有序区和无序区，每一趟排序都在无序区依次对比，记录对比区域的最小元素的位置
        //然后把无序区第一个元素和所记录的最小元素进行交换，无序区少一个，有序区多一个，循环往复直至无序区
        //元素数量为0；
//=============================================================
        for (int i = 0; i < items.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[k].compareTo(items[j]) > 0) {
                    k = j;
                }
            }
            swap(k, i);
        }
    }
//=============================================================
//        int num=10;
//        for (int i=0;i<num-1;i++){
//            for (int j=0;j<num-1;j++){
//                if (items[j]>items[j+1]) {
//                    int temp;
//                    temp = items[j];
//                    items[j] = items[j + 1];
//                    items[j + 1] = temp;
//                }
//            }
//        }
//==========================================================================================
        //todo:直接插入排序的具体实现
        //分为有序区域和无序区域，每一趟都先跟后面一个无序区域的对比，对比记录无序区域和有序区域中最小的那个数放在RO篮子里面
        //然后无序区域跟有序区域的值对比依次排列，无序区域中的那个值放到有序区域中
//===========================================================================
        public void insertsort() {
            for (int i = 1; i < items.length; i++) {
                int j = i - 1;
                if (items[j].compareTo(items[i]) < 0) {
                    continue;
                }
                Integer tmg = items[i];
                while (j >= 0 && items[j].compareTo(tmg) > 0) {

                    items[j + 1] = items[j];
                    j--;
                }
                items[j + 1] =tmg;
            }
        }


    public void swap(int k, int i) {
        int tmp =items[k];
        items[k]=items[i];
        items[i]=tmp;
    }

    public void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }

}
