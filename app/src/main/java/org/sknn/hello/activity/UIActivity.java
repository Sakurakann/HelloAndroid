package org.sknn.hello.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.sknn.hello.R;

public class UIActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private EditText editText;
    private int imageInt;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;


    private int begin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        imageView = findViewById(R.id.ui_image1);
        imageInt = R.drawable.jeesoon;
        Button button = findViewById(R.id.ui_button1);
        Button button2 = findViewById(R.id.ui_button2);
        Button button3 = findViewById(R.id.ui_button3);
        editText = findViewById(R.id.ui_edit1);
        progressBar = findViewById(R.id.ui_progressBar1);
        progressBar2 = findViewById(R.id.ui_progressBar2);


        Button button_alert = findViewById(R.id.ui_button_alert);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button_alert.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ui_button1:

                if (imageInt == R.drawable.jeesoon) {
                    imageView.setImageResource(R.drawable.i1503015998357);
                    imageInt = R.drawable.i1503015998357;
                    editText.setText(new char[]{'s', 'a', 'k', 'u'}, 0, 4);
                } else {
                    imageView.setImageResource(R.drawable.jeesoon);
                    imageInt = R.drawable.jeesoon;
                    editText.setText(new char[]{'s', 'k', 'n', 'n'}, 0, 4);
                }
                break;
            case R.id.ui_button2:
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.ui_button3:
                begin = 0;
                progressBar2.setVisibility(View.VISIBLE);
                mHandler.post(mProgressThread);
                break;
            case R.id.ui_button_alert:
                Toast.makeText(UIActivity.this, "进入DEBUG", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(UIActivity.this);
                // 设置警告框的标题
                builder.setTitle("Alert dialog");
                // 设置标题旁的图标
                //builder.setIcon(1);

                // 设置要显示的文本内容
                builder.setMessage("Warning!!");

                // 能否绕过该警告框(点击其他区域能否取消该警告框)
                builder.setCancelable(false);

                // 设置点击确认按钮的动作
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(UIActivity.this, "确定哦", Toast.LENGTH_SHORT).show();
                    }
                });
                // 设置点击取消按钮的动作
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(UIActivity.this, "取消了", Toast.LENGTH_SHORT).show();
                    }
                });

                // 创建警告对话框
                AlertDialog alertDialog = builder.create();

                // 显示警告对话框
                alertDialog.show();
                break;


            default:
                break;
        }
    }

    // 异步回传消息并处理
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    progressBar2.setProgress(msg.arg1);
                    mHandler.post(mProgressThread);
                    break;
                default:
                    break;

            }
        }
    };

    Runnable mProgressThread = new Runnable() {
        int step = 1;

        @Override
        public void run() {
            begin += step;
            if (begin > 100) {
                mHandler.removeCallbacks(mProgressThread);
            } else {
                Message message = mHandler.obtainMessage();
                message.arg1 = begin;
                message.what = 1;
                mHandler.sendMessageAtTime(message, 100);
            }

        }
    };
}
