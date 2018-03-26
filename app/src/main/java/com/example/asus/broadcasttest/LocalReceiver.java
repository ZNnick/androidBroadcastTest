package com.example.asus.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ASUS on 2018/3/26.
 */

class LocalReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"local Broadcast",Toast.LENGTH_SHORT).show();
    }
}
