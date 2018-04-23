package org.sknn.hello;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.sknn.hello.listview.adapter.FruitAdapter;
import org.sknn.hello.listview.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
    private List<Fruit> fruits = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sknn);

        ActionBar supportActionBar = getSupportActionBar();
        // 隐藏系统自带标题栏
        if (supportActionBar != null) {
            supportActionBar.hide();
        }

        Fruit fruit;
        for (int i = 0; i < data.length; i++) {
            if (i % 2 == 0) {
                fruit = new Fruit(data[i], R.drawable.apple_pic);
                fruits.add(fruit);
                continue;
            }
            fruit = new Fruit(data[i], R.drawable.banana_pic);
            fruits.add(fruit);
        }

        FruitAdapter fruitAdapter = new FruitAdapter(ListViewActivity.this, R.layout.fruit, fruits);

        // adapter 的参数必须包含TextView, 其中android.R.layout.simple_list_item_1
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this, android.R.layout.simple_list_item_1, data);
        ListView fruitView = (ListView) findViewById(R.id.sknn_listView);
        fruitView.setAdapter(fruitAdapter);
        fruitView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit1 = fruits.get(position);
                Toast.makeText(ListViewActivity.this, fruit1.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
