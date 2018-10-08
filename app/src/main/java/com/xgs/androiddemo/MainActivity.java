package com.xgs.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.PermissionRequest;

import com.xgs.androiddemo.chapter1.PermissionsActivity;
import com.xgs.androiddemo.chapter1.ToolBarActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, PermissionsActivity.class);
        startActivity(intent);
    }
}
