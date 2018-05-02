package org.sknn.hello;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HeapActivity extends AppCompatActivity {
    private static final String TAG = "HeapActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heap);

        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(info);
        Log.i(TAG, "内存分配大小: " + activityManager.getMemoryClass());
        Log.i(TAG, "largeMemory: " + activityManager.getLargeMemoryClass());
        Log.i(TAG,"系统剩余内存:"+(info.availMem >> 10)+"k");
        Log.i(TAG,"系统是否处于低内存运行："+info.lowMemory);
        Log.i(TAG,"当系统剩余内存低于"+info.threshold+"时就看成低内存运行");

        /*ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memoryClass = activityManager.getMemoryClass();
        int largeMemoryClass = activityManager.getLargeMemoryClass();*/

    }
}
