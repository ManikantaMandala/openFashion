package com.bmlmunjal.openfashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mSliderViewPager;
    private LinearLayout mDotLayout;
    private Button LogInButton,SignUpButton;

    TextView[] dots;
    ViewPagerAdaptor viewPagerAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        LogInButton=findViewById(R.id.buttonLogIn);
        SignUpButton=findViewById(R.id.buttonSignUp);

        mSliderViewPager= findViewById(R.id.viewPageImageSlider);
        mDotLayout=(LinearLayout) findViewById(R.id.theShiftingDots);
        viewPagerAdaptor= new ViewPagerAdaptor(this);
        mSliderViewPager.setAdapter(viewPagerAdaptor);

        setUpIndicator(0);

        mSliderViewPager.addOnPageChangeListener(viewListener);

        LogInButton.setOnClickListener(this);
        SignUpButton.setOnClickListener(this);
    }

    public void setUpIndicator(int position){
        mDotLayout.removeAllViews();
        dots= new TextView[3];
        Log.d("Test", "onPageSelected: It entered setUpIndicator");
        for(int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            Log.d("Test", "onPageSelected: It entered changeListener");
            setUpIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.buttonLogIn):
                startActivity(new Intent(MainActivity.this,logInActivity.class));
                break;
            case (R.id.buttonSignUp):
                startActivity(new Intent(MainActivity.this,signUpActivity.class));
                break;
        }
        setContentView(R.layout.activity_onboarding);
    }
}