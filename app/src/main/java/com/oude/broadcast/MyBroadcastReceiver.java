package com.oude.broadcast;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context p1, Intent p2)
    {
        Toast.makeText(p1,"接收",Toast.LENGTH_SHORT).show();
    }

    
}
