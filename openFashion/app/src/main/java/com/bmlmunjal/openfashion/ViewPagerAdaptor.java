package com.bmlmunjal.openfashion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdaptor extends PagerAdapter {
    Context context;
    int image[]={
            R.drawable.profile_picture,
            R.drawable.profile_picture,
            R.drawable.profile_picture,
    };
    int noOfSlides[]={
            R.string._1_of_3,
            R.string._2_of_3,
            R.string._3_of_3
    };

    int heading[]={
            R.string.text_view_heading1,
            R.string.text_view_heading2,
            R.string.text_view_heading3,
    };

    int description[]={
            R.string.description1,
            R.string.description2,
            R.string.description3,
    };

    public ViewPagerAdaptor(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);
        ImageView slideImage= (ImageView) view.findViewById(R.id.slideImage);
        TextView sliderLayoutSlideNumbers = (TextView) view.findViewById(R.id.sliderLayoutSlideNumbers);
        TextView sliderLayoutTextViewTitle = (TextView) view.findViewById(R.id.sliderLayoutTextViewTitle);
        TextView sliderLayoutTextViewDescription = (TextView) view.findViewById(R.id.sliderLayoutTextViewDescription);

        slideImage.setImageResource(image[position]);
        sliderLayoutSlideNumbers.setText(noOfSlides[position]);
        sliderLayoutTextViewTitle.setText(heading[position]);
        sliderLayoutTextViewDescription.setText(description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
