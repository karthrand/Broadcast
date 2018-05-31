package com.oude.broadcast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class StaticNetworkChangeReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context p1, Intent p2)
    {
        ConnectivityManager connectivityManager =(ConnectivityManager) p1.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()){
            Toast.makeText(p1,"外部:网络已连接!",Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(p1,"外部:网络不可用!",Toast.LENGTH_SHORT).show();
        }
    }

    
}
