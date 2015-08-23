package com.example.development.baseproject.protip;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;

import com.example.development.baseproject.R;

public class TranslucentActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawInsetsFrameLayout drawInsetsFrameLayout = (DrawInsetsFrameLayout) findViewById(R.id.my_draw_insets_layout);
        drawInsetsFrameLayout.setOnInsetsCallback(new DrawInsetsFrameLayout.OnInsetsCallback() {
            @Override
            public void onInsetsChanged(Rect insets) {

            }
        });
    }
}