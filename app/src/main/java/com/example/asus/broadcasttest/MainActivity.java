package com.example.asus.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter =new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//创建一个系统服务类的实例，该类专门用于管理网络连接。
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null && networkInfo.isAvailable()){
                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
            }


        }
    }
}
