package com.shake.madhacks.shake;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager notificationManager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
                && !notificationManager.isNotificationPolicyAccessGranted()) {

            Intent intent = new Intent(
                    android.provider.Settings
                            .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);

            startActivity(intent);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
        moveTaskToBack(true);
    }

    // Method to stop the service
    public void stopService(View view) {
        finish();
//        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
