package com.example.marcos.appejercicios.View;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.marcos.appejercicios.MainActivity;
import com.example.marcos.appejercicios.R;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageLogoEntre = findViewById(R.id.splashLogoEntrenate);
        ImageView imageLogoBa = findViewById(R.id.splashLogoBa);
        @SuppressLint("ResourceType") Animation myAnimation = AnimationUtils.loadAnimation(this, R.transition.trasnsition_splash);
        imageLogoEntre.startAnimation(myAnimation);
        imageLogoBa.startAnimation(myAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);

            }
        }, 2000);
    }
}
