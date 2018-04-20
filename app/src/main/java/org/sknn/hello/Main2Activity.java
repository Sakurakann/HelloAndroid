package org.sknn.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Intent intent = getIntent();
        String toast = intent.getStringExtra("toast");
        if (toast != null && !"".equals(toast))
            Toast.makeText(Main2Activity.this, toast, Toast.LENGTH_SHORT).show();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("data_return", "I'm back");
                setResult(RESULT_OK, intent1);
                finish();
            }
        });

    }

    // 重写返回按键返回过程, 防止不是按钮返回上一个activity
    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent();
        intent1.putExtra("data_return", "I'm back");
        setResult(RESULT_OK, intent1);
        finish();
    }
}
