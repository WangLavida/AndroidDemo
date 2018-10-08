package com.xgs.androiddemo.chapter1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.xgs.androiddemo.R;
import com.xgs.androiddemo.adapter.RecyclerAdapter;
import com.xgs.androiddemo.view.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        dataList = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            dataList.add(i + "");
        }
    }

    private void initView() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
////        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//水平排序
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(RecyclerActivity.this, DividerItemDecoration.VERTICAL_LIST));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //九宫格
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(RecyclerActivity.this));


        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(RecyclerActivity.this, dataList);
        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerActivity.this, position + "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                new AlertDialog.Builder(RecyclerActivity.this).setTitle("温馨提示").setMessage("确认删除").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recyclerAdapter.removeData(position);
                    }
                }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
        recyclerView.setAdapter(recyclerAdapter);
    }
}
