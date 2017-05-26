package com.group7.dearbaby.me.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.group7.dearbaby.R;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class BaiDuactivity extends AppCompatActivity {
    /**
     * 定位SDK核心类
     */
    private LocationClient locationClient;
    /**
     * 定位监听
     */
    public MyLocationListenner myListener = new MyLocationListenner();
    /**
     * 百度地图控件
     */
    private MapView mapView;
    /**
     * 百度地图对象
     */
    private BaiduMap baiduMap;

    boolean isFirstLoc = true; // 是否首次定位
    private Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.recycler_addmap);
        //获得资源id
        mapView = (MapView) findViewById(R.id.bmapView);
        btnback = (Button) findViewById(R.id.btnback);
        //获取百度地图对象
        baiduMap = mapView.getMap();
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        baiduMap.setTrafficEnabled(true);
        // 开启定位图层
        baiduMap.setMyLocationEnabled(true);
        //声明定位SDK核心类
        locationClient = new LocationClient(this);
        //注册监听
        locationClient.registerLocationListener(myListener);
        //定位配置信息
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);//定位请求时间间隔
        locationClient.setLocOption(option);
        option.setIsNeedAddress(true);//反编译获得具体位置，只有网络定位才可以
        option.setAddrType("all");
        //开启定位
        locationClient.start();
    }
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null || mapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            baiduMap.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                StringBuffer sb = new StringBuffer(256);
                sb.append("time : ");
                sb.append(location.getTime());//获得当前时间
                sb.append("\nerror code : ");
                sb.append(location.getLocType());//获得erro code得知定位现状
                sb.append("\nlatitude : ");
                sb.append(location.getLatitude());//获得纬度
                sb.append("\nlontitude : ");
                sb.append(location.getLongitude());//获得经度
                sb.append("\nradius : ");
                         sb.append(location.getRadius());
                if (location.getLocType() == BDLocation.TypeGpsLocation){//通过GPS定位
                    sb.append("\nspeed : ");
                    sb.append(location.getSpeed());//获得速度
                    sb.append("\nsatellite : ");
                    sb.append(location.getSatelliteNumber());
                    sb.append("\ndirection : ");
                   sb.append("\naddr : ");
                    sb.append(location.getAddrStr());//获得当前地址
                   sb.append(location.getDirection());//获得方位
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){//通过网络连接定位
                 sb.append("\naddr : ");
                    Log.e("e",location.getAddrStr()+"");
                    sb.append(location.getAddrStr());//获得当前地址
                    //运营商信息
                      sb.append("\noperationers : ");
                      sb.append(location.getOperators());//获得经营商？
                }
                logMsg(sb.toString());
                Log.i("BaiduLocationApiDem", sb.toString());
            }

        }



        public void onReceivePoi(BDLocation poiLocation) {
        }
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // 退出时销毁定位
        locationClient.stop();
        // 关闭定位图层
        baiduMap.setMyLocationEnabled(false);
        mapView.onDestroy();
        mapView = null;
        super.onDestroy();
    }
    public void logMsg(final String str) {
        try {
            btnback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it=new Intent();
                    it.putExtra("address",str);
                     setResult(100,it);
                    finish();
       
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
