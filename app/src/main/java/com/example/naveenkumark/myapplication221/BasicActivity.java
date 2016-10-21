package com.example.naveenkumark.myapplication221;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String s1 = "Hello";
        String s2 = "hello";

        System.out.println("Comparing s1 and s2" + s1.compareTo(s2));



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*startActivity(new Intent(BasicActivity.this, MainActivity.class));*/
                Snackbar.make(view, findTwoNumbersWithSum(Arrays.asList(0, 3, 1, 4, 8, 3, 3, 6, 5), 6), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //All the duplicated items with count
    //See if you can get then order in which they are duplicated

    public String findFirstItemDuplicated(List<Integer> list){

        if(null == list){
            return "I didn't get any list";
        }

        if(list.size() == 0){
            return "The list is empty";
        }



        Integer index = 0;
        int firstRepeatedIndex = -1;
        Map<Integer, Integer> map = new HashMap<>();
        //map.con
        for (Integer item : list) {
            if( map.containsKey(item) ){
                if(firstRepeatedIndex == -1) {
                    firstRepeatedIndex = map.get(item);
                }
                if(map.get(item) < firstRepeatedIndex) {
                    firstRepeatedIndex = map.get(item);
                }
                if(firstRepeatedIndex == 0) {
                    System.out.println("Broke out early");
                    Log.d("TAG", "findFirstItemDuplicated: Broke out early");
                    break;
                }
            } else {
                map.put(item, index);
            }
            index++;
        }
        if(firstRepeatedIndex == -1) {
            return "No duplicate items found";
        } else {
            return ("First repeated item is: " + list.get(firstRepeatedIndex));
        }
    }

    //Find all permutations whose sum is "sum"
    private String findTwoNumbersWithSum(List<Integer> list, int sum) {

        if(null == list){
            return "I didn't get any list";
        }

        if(list.size() <= 1){
            return "The list doesn't have enough elements to do a sum";
        }

        String returnValue = "No such combination found";
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer item :
                list) {
            if (map.containsKey(sum - item)){
                returnValue = "The two indices are " + index + " and " + map.get(sum-item);
                break;
            } else if(!map.containsKey(item)){
                map.put(item, index);
            }
            index++;
        }
        return returnValue;
    }
}
