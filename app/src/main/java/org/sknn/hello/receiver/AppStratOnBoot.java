package org.sknn.hello.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.sknn.hello.MainActivity;
import org.sknn.hello.activity.UIActivity;

public class AppStratOnBoot extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent uiActivity = new Intent(context, MainActivity.class);

            uiActivity.setAction("android.intent.action.MAIN");
            uiActivity.addCategory("android.intent.category.LAUNCHER");
            uiActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(uiActivity);
        }
    }
}
