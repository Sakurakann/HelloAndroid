package org.sknn.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import org.sknn.hello.activity.DialogActivity;
import org.sknn.hello.activity.NormalActivity;
import org.sknn.hello.activity.UIActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    /**
     * 其中的Bundle就是onSaveInstanceState保存的数据包
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "MainActivity on create", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.first_layout);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "This is a toast", Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("MainActivity", "onCreate execute");

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finish 是父类中的方法, 表示销毁当前活动, 与返回键效果相同
                finish();
            }
        });

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            /**
             * 显式调用intent
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                // 在Intent中设置参数, 在Activity中进行值传递
                intent.putExtra("toast", "this is msg from other activity");
                startActivityForResult(intent, 2);

            }
        });

        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            /**
             * 隐式调用intent
             * @param view
             */
            @Override
            public void onClick(View view) {
                // 在AndroidManifest.xml的intent-filter 中 <action android:name="aaaaaaaaaaaaa"/> 指定别名
                Intent intent = new Intent("aaaaaaaaaaaaa");
                intent.addCategory("android.intent.category.DEFAULT");
                //startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });


        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                // 使用intent传递bundle数据包
                //intent.putExtras(new Bundle());
                startActivity(intent);
            }
        });

        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UIActivity.class);
                // 使用intent传递bundle数据包
                //intent.putExtras(new Bundle());
                startActivity(intent);
            }
        });

    }

    // 有返回的活动, 并附带参数
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // requestCode 是开启有返回值的activity时, startActivityForResult方法中的第二ge参数
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(MainActivity.this, data.getStringExtra("data_return"), Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(MainActivity.this, "data_return", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }


    }

    /**
     * 创建活动菜单 右上
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        // true表示显示该菜单
        return true;
    }

    /**
     * 为活动菜单添加动作
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(MainActivity.this, "Click add menu item", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this, "Click remove menu item", Toast.LENGTH_LONG).show();
                break;
            default:
                break;

        }
        // true 表示显示
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "MainActivity on start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "MainActivity on resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "MainActivity on pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "MainActivity on stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "MainActivity on destroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "MainActivity on restart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("sknn", "sakura");
    }
}
