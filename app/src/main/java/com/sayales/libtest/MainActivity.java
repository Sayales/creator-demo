package com.sayales.libtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.sayales.libtest.viewholders.FooterViewHolder;
import com.sayales.libtest.viewholders.MyViewHolder;
import com.sayales.recyclerviewadaptercreator.SwipeAction;
import com.sayales.recyclerviewadaptercreator.ViewHolderBinder;
import com.sayales.recyclerviewadaptercreator.interfaces.Configured;
import com.sayales.recyclerviewadaptercreator.stdimplementation.RecyclerViewAdapterCreator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> listData = new ArrayList<String>() {{
            add("Test 1");
            add("Test 2");
            add("Test 3");
        }};
        final RecyclerView view = (RecyclerView) findViewById(R.id.recyc_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter = RecyclerViewAdapterCreator.withData(listData)
                .onSwipeAction(view, new SwipeAction() {
                    @Override
                    public void action(int i, Configured configured, RecyclerView.Adapter adapter) {
                        FooterViewHolder holder = (FooterViewHolder) configured.getFooter();
                        holder.getTextView().setText("swiped " + configured.getData().get(i));
                        configured.getData().remove(i);
                        adapter.notifyDataSetChanged();
                    }
                })
                .withFooterViewHolder(FooterViewHolder.class, R.layout.footer)
                .withViewHolder(MyViewHolder.class, R.layout.elem)
                .withViewHolderBinder(new ViewHolderBinder<String>() {
                    @Override
                    public void bind(RecyclerView.ViewHolder viewHolder, int i, final Configured<String> configuredInterface) {
                        if (viewHolder instanceof MyViewHolder) {
                            MyViewHolder trueHolder = (MyViewHolder) viewHolder;
                            trueHolder.getText().setText(configuredInterface.getData().get(i));
                        }
                        if (viewHolder instanceof FooterViewHolder) {
                            final FooterViewHolder trueHolder = (FooterViewHolder) viewHolder;
                            trueHolder.getButton().setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    myOnClickListener(trueHolder, configuredInterface.getData());
                                }
                            });
                        }
                    }
                })
                .create();
        view.setAdapter(adapter);
    }

    private void myOnClickListener(FooterViewHolder trueHolder, List<String> data) {
        EditText text = trueHolder.getEditText();
        data.add(text.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
