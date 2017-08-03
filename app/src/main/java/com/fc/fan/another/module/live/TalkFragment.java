package com.fc.fan.another.module.live;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.LiveMessageAdapter;
import com.fc.fan.another.base.RxLazyFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fan on 8/3/17.
 * A nice day..
 */

public class TalkFragment extends RxLazyFragment {
    public static final String TAG = TalkFragment.class.getSimpleName();

    public static TalkFragment newInstance() {
        return new TalkFragment();
    }

    @BindView(R.id.live_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.live_send)
    ImageView send;

    @BindView(R.id.live_edit)
    EditText editText;

    List<String> list;

    LiveMessageAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_talk;
    }

    @Override
    public void finishCreateView(Bundle state) {
        list = new ArrayList<>();
        adapter = new LiveMessageAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        send.setOnClickListener(view -> {
            String message = editText.getText().toString();
            list.add(message);
            editText.setText("");
            adapter.notifyDataSetChanged();
            recyclerView.smoothScrollToPosition(adapter.getItemCount());
        });

        sendMessage();
    }

    private void sendMessage() {
        String[] messages = new String[]{"千浅签：感觉有点难", "陌陌：老师讲得还不错", "老李：66666666666",
                "哈哈", "哈哈", "哈哈",
                "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈",
                "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈",
                "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈",
                "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈",
                "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈", "哈哈"};

        Observable<String> ob = Observable.create(x -> {
            Thread.sleep(2000);
            for (String s : messages) {
                x.onNext(s);
                Thread.sleep(new Random().nextInt(2500));
            }
            x.onComplete();
        });

        ob.compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(x -> {
                    list.add(x);
                    adapter.notifyDataSetChanged();
                    recyclerView.smoothScrollToPosition(adapter.getItemCount());
                });
    }
}
