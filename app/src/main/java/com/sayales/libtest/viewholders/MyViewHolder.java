package com.sayales.libtest.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sayales.libtest.R;

/**
 * Created by Pavel on 30.10.2016.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView text;

    public MyViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.text_view);
    }

    public TextView getText() {
        return text;
    }

    public void setText(TextView text) {
        this.text = text;
    }
}
