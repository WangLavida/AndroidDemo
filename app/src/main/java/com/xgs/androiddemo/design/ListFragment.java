package com.xgs.androiddemo.design;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xgs.androiddemo.R;
import com.xgs.androiddemo.adapter.RecyclerAdapter;
import com.xgs.androiddemo.common.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    @BindView(R.id.rcl)
    RecyclerView rcl;
    private List<String> dataList;
    Unbinder unbinder;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        dataList = new ArrayList<String>();
        for (int i = 0; i < 40; i++) {
            dataList.add(i + "");
        }
        rcl.setLayoutManager(new LinearLayoutManager(getContext()));
        rcl.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
        rcl.setAdapter(new RecyclerAdapter(getContext(), dataList));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
