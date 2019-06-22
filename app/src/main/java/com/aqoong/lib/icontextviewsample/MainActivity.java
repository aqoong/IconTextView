package com.aqoong.lib.icontextviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aqoong.lib.icontextview.IconTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IconTextView textView = findViewById(R.id.textview3);
        textView.setTextAlignment(IconTextView.TEXT_ALIGN.LEFT);

    }
}
