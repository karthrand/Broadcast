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
import android.net.Network;

public class MainActivity extends AppCompatActivity 
{
    /** 
    //动态广播接收器第一步：声明两个网络管理对象和接收的意图类型
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    **/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /**
        //动态广播接收器第三步：实例创建、确定接收广播类型和注册广播
        intentFilter =new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver =new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        **/
    }
    
    /**
     //动态广播接收器第四步:取消广播接收器的注册
     //最后一步是去清单文件添加权限
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
    
    
    //动态广播接收器第二步：创建对应的广播接收器的内部类,并进行基本的网络链接判断
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
    
    **/
    
}
