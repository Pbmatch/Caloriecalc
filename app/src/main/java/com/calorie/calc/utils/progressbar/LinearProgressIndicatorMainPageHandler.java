package com.calorie.calc.utils.progressbar;

import android.content.Context;
import android.widget.TextView;

import com.calorie.calc.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class LinearProgressIndicatorMainPageHandler extends LinearProgressIndicatorHandler{
    public LinearProgressIndicatorMainPageHandler(LinearProgressIndicator progressIndicator, int progressColor, Context context, TextView textView) {
        super(progressIndicator, progressColor, context, textView);
    }

    @Override
    protected void setTextViewProgress(double total, double dailyNorm) {
        System.out.println("FatProgressSett" + total+dailyNorm);
        if (textView!=null)
        {
            if(total==0)
            {
                textView.setText( String.format("%.1f", dailyNorm) + " " + context.getString(R.string.gramm));
            }
            else
            {
                double more=dailyNorm-total;
                textView.setText(context.getString(R.string.more) +" "+
                        String.format("%.1f", more) + " " + context.getString(R.string.gramm));
            }



        }
    }
}
