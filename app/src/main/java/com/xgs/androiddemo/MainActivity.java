package com.xgs.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.PermissionRequest;

import com.xgs.androiddemo.chapter1.PermissionsActivity;
import com.xgs.androiddemo.chapter1.ToolBarActivity;
import com.xgs.androiddemo.design.DesignActivity;
import com.xgs.androiddemo.design.TabActivity;
import com.xgs.androiddemo.view.ViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
}
