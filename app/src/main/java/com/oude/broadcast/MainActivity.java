package com.oude.broadcast;

import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity 
{
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        intentFilter =new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver =new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        
    }
    
    class NetworkChangeReceiver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context p1, Intent p2)
        {
            ConnectivityManager connectivityManager =(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(p1,"网络已连接!",Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(p1,"网络不可用!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
