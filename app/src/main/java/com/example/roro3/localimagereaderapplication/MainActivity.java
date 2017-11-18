package com.example.roro3.localimagereaderapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    ImageView loadImg;
    ImageView imag1;
    AnimationDrawable frameAnimation;

    private List<Integer> mipmapImageArray = Arrays.asList(R.mipmap.test1,R.mipmap.discover_page_main);
    private List<Integer> imageView = Arrays.asList(R.id.spinning_wheel_image,R.id.spinning_wheel_image1);
    private List<Integer> imageViewSource =Arrays.asList(R.drawable.spin_animation,R.drawable.spin_animation1);
    private List<ImageView> listImageView =Arrays.asList(img,imag1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadImg = (ImageView)findViewById(R.id.loadedImage);
        loadImg.setBackgroundResource(mipmapImageArray.get(1));
        for(int i = 0; i<2;i++) {
            test(i);
        }
    }

    private void test(final int i){
        ImageView viewTest = listImageView.get(i);
         viewTest= (ImageView)findViewById(imageView.get(i));
        final int sourceData =imageViewSource.get(i);
        viewTest.setBackgroundResource(imageViewSource.get(i));
        // Get the background, which has been compiled to an AnimationDrawable object.
        frameAnimation = (AnimationDrawable) viewTest.getBackground();

        // Start the animation (looped playback by default).
        frameAnimation.start();
        final ImageView finalViewTest = viewTest;
        viewTest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    finalViewTest.setBackgroundResource(R.mipmap.main_background_image);
                    Intent intent = new Intent(MainActivity.this,NextPageActivity.class);
//                    startActivity(intent);
                    return true;
                }else if (event.getAction() == MotionEvent.ACTION_UP) {
                    finalViewTest.setBackgroundResource(sourceData);
                    // Get the background, which has been compiled to an AnimationDrawable object.
                    frameAnimation = (AnimationDrawable) finalViewTest.getBackground();
                    // Start the animation (looped playback by default).
                    frameAnimation.start();
                    return true;
                }
                return false;
            }
        });
    }
}
