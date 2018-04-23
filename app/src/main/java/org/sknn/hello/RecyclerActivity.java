package org.sknn.hello;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import org.sknn.hello.listview.adapter.FruitRecyclerAdapter;
import org.sknn.hello.listview.bean.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerActivity extends AppCompatActivity {
    private List<Fruit> fruits = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        RecyclerView view = findViewById(R.id.recycle_view);
        /*// 线性布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 线性布局水平排列
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);*/

        // 流式布局
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);



        view.setLayoutManager(layoutManager);
        // 初始化数据
        initData();
        view.setAdapter(new FruitRecyclerAdapter(fruits));
    }

    private void initData() {
        int len = 10;
        Fruit fruit;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                fruit = new Fruit(getStrRandom(), R.drawable.apple_pic);
                fruits.add(fruit);
                continue;
            }
            fruit = new Fruit(getStrRandom(), R.drawable.banana_pic);
            fruits.add(fruit);
        }


    }

    private String getStrRandom() {
        int i = new Random().nextInt(20);
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < i; j++) {
            int i1 = new Random().nextInt(125);
            builder.append(Integer.toHexString(i1));
        }
        return builder.toString();
    }

}
