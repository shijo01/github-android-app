package com.example.userx.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button mRunButton;
    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRunButton = (Button) findViewById(R.id.button);
        mLayout = (LinearLayout) findViewById(R.id.layout);
        mRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleView(mLayout, 0f, 0.6f);
                //mLayout.animate().scaleX(2.5f).scaleY(5f).setDuration(400).start();
                LinearLayout loginForm = (LinearLayout) getLayoutInflater().inflate(R.layout.login_form, mLayout, false);
                mLayout.addView(loginForm);
            }
        });



    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                1f, 2f, // Start and end values for the X axis scaling
                1f, 5f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1.0f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(300);
        v.startAnimation(anim);
    }
}
