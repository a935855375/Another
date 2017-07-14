package com.fc.fan.another.module.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fc.fan.another.R;

/**
 * Created by fan on 7/14/17.
 */

public class TestFragment extends Fragment {

    private String id;

    public static TestFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString("id", id);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getString("id");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test, container, false);
        TextView textView = (TextView) view;
        textView.setText("Fragment" + id);
        return view;
    }
}
