package com.xgs.androiddemo.design;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xgs.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DesignActivity extends AppCompatActivity {

    @BindView(R.id.ll_content)
    RelativeLayout llContent;
    @BindView(R.id.til_name)
    TextInputLayout tilName;
    @BindView(R.id.til_pwd)
    TextInputLayout tilPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (tilName.getEditText().getText().toString().isEmpty()) {
                    tilName.setErrorEnabled(true);
                    tilName.setError("用户名错误");
                    return;
                }
                if (tilPwd.getEditText().getText().toString().isEmpty()) {
                    tilPwd.setErrorEnabled(true);
                    tilPwd.setError("密码错误");
                    return;
                }
                tilName.setErrorEnabled(false);
                tilPwd.setErrorEnabled(false);
                Toast.makeText(DesignActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                break;
            case R.id.fab:
                Snackbar.make(llContent, "标题", Snackbar.LENGTH_LONG).setAction("点击事件", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DesignActivity.this, "点击了", Toast.LENGTH_LONG).show();
                    }
                }).show();
                break;
        }
    }
}
