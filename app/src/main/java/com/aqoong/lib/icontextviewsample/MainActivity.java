package com.aqoong.lib.icontextviewsample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.aqoong.lib.icontextview.IconTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IconTextView textView = findViewById(R.id.textview1);
        textView.setIconSrc(ContextCompat.getDrawable(this, R.drawable.ic_launcher_foreground));
        textView.setTextSize(20);
    }
}
