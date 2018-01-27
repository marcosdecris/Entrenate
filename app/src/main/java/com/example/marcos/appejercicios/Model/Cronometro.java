package com.example.marcos.appejercicios.Model;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Chronometer;



/**
 * Created by Marcos on 23-Jan-18.
 */

public class Cronometro extends Chronometer {
    public Cronometro(Context context) {
        super(context);
    }

    public Cronometro(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Cronometro(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Cronometro(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
