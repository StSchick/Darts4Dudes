package com.heidescrimeproducts.darts4dudes;

import android.view.View;

/**
 * Created by tak3r07 on 4/8/15.
 * Custom OnClickListener to add an outer variable
 */
public abstract class MyOnClickListener implements View.OnClickListener {
    int i;
    MyOnClickListener(int i){
        this.i = i;
    }
}
