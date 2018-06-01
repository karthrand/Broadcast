package com.oude.broadcast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
import android.os.Build;
import android.net.Network;


//静态广播接收器第一步：创建对应的接收器类，并实现onRwceive方法
public class StaticNetworkChangeReceiver extends BroadcastReceiver
{
    private Integer networkType;
    private String networkName;
    private boolean networkConnected;

    @Override
    public void onReceive(Context p1, Intent p2)
    {
        //调用判定网络是否连接方法
        networkConnected = isNetworkAvailable(p1);
        
        if (networkConnected){
            ConnectivityManager connectivityManager =(ConnectivityManager) p1.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            networkType = networkInfo.getType();
            networkName = networkInfo.getSubtypeName();
            
            switch (networkType){
                case connectivityManager.TYPE_BLUETOOTH:
                    networkName = "蓝牙热点";
                    break;
                case connectivityManager.TYPE_MOBILE:
                    networkName = "手机流量";
                    break;
                case connectivityManager.TYPE_WIFI:
                    networkName = "WIFI";
                    break;
                case connectivityManager.TYPE_VPN:
                    networkName = "VPN";
                    break;
                default:
                    networkName="";  
            }
            
            Toast.makeText(p1,networkName +"网络已连接!",Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(p1,"网络已断开!",Toast.LENGTH_SHORT).show();
        }
    }
    
    
    //判定网络是否已连接
    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        //新版本调用方法获取网络状态
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] networks = connectivity.getAllNetworks();
            NetworkInfo networkInfo;
            for (Network mNetwork : networks) {
                networkInfo = connectivity.getNetworkInfo(mNetwork);
                if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                }
            }
        } else {
            //否则调用旧版本方法
            if (connectivity != null) {
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                if (info != null) {
                    for (NetworkInfo anInfo : info) {
                        if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    
}
