package org.sknn.hello.layout;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.sknn.hello.R;

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 对标题栏布局进行动态加载, inflate加载布局文件和其父布局
        LayoutInflater.from(context).inflate(R.layout.title, this);

        findViewById(R.id.title_back).setOnClickListener(this);
        findViewById(R.id.title_edit).setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                ((Activity) getContext()).finish();
                break;
            case R.id.title_edit:
                Toast.makeText(getContext(), "edit text", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
