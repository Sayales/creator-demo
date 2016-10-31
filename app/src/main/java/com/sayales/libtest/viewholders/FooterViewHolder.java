package com.sayales.libtest.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sayales.libtest.R;

/**
 * Created by Pavel on 31.10.2016.
 */

public class FooterViewHolder extends RecyclerView.ViewHolder {

    private EditText editText;
    private TextView textView;
    private Button button;

    public FooterViewHolder(View itemView) {
        super(itemView);
        editText = (EditText) itemView.findViewById(R.id.text_inpt);
        textView = (TextView) itemView.findViewById(R.id.footer_text);
        button = (Button) itemView.findViewById(R.id.foot_button);
    }

    public EditText getEditText() {
        return editText;
    }

    public TextView getTextView() {
        return textView;
    }

    public Button getButton() {
        return button;
    }
}
