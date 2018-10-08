package com.xgs.androiddemo.chapter1;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.xgs.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
@TargetApi(Build.VERSION_CODES.O)
@RequiresApi(api = Build.VERSION_CODES.O)
public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.btn_nomal)
    Button btnNomal;
    @BindView(R.id.btn_fold)
    Button btnFold;
    @BindView(R.id.btn_hang)
    Button btnHang;
    NotificationManager notificationManager;
    String id ="channel_1";//channel的id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        String description = "123";//channel的描述信息
        int importance = NotificationManager.IMPORTANCE_LOW;//channel的重要性
        NotificationChannel channel = new NotificationChannel(id, description, importance);//生成channel
        notificationManager.createNotificationChannel(channel);
    }
    private void sendNomal() {
        Notification.Builder builder = new Notification.Builder(NotificationActivity.this,id);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setContentText("这是一个通知");
        builder.setContentText("普通通知");
        builder.setAutoCancel(true);
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        notificationManager.notify(0, builder.build());
    }

    private void sendFold() {
        Notification.Builder builder = new Notification.Builder(NotificationActivity.this,id);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setContentText("这是一个通知");
        builder.setContentText("折叠通知");
        builder.setAutoCancel(true);
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        Notification notification = builder.build();
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.noti_fold);
        notification.bigContentView = remoteViews;
        notificationManager.notify(0, notification);
    }

    private void sendHang() {
        Notification.Builder builder = new Notification.Builder(NotificationActivity.this,id);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setContentText("这是一个通知");
        builder.setContentText("悬挂通知");
        builder.setAutoCancel(true);
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        Intent hangIntent = new Intent();
        hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hangIntent.setClass(this, RecyclerActivity.class);
        //如果描述的PendingIntent已经存在，则在产生新的Intent之前会先取消掉当前的
        PendingIntent hangPendingIntent = PendingIntent.getActivity(this, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(hangPendingIntent, true);
        notificationManager.notify(0, builder.build());
    }

    @OnClick({R.id.btn_nomal, R.id.btn_fold, R.id.btn_hang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_nomal:
                sendNomal();
                break;
            case R.id.btn_fold:
                sendFold();
                break;
            case R.id.btn_hang:
                sendHang();
                break;
        }
    }
}
