package com.calorie.calc.utils.progressbar;

import android.content.Context;
import android.widget.TextView;

import com.calorie.calc.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class LinearProgressIndicatorHandler
{
        private LinearProgressIndicator progressIndicator;

    private int progressColor;
    private  Context context;
    private TextView textView;

    public LinearProgressIndicatorHandler(LinearProgressIndicator progressIndicator, int progressColor, Context context, TextView textView) {
        this.progressIndicator = progressIndicator;
        this.progressColor = progressColor;
        this.context = context;
        this.textView = textView;
    }

    public void setProgress(double total, double dailyNorm)
        {
         int progress=   CalculateProgressIndicator.getProgress(total ,dailyNorm);
              if(progress>99)
                      progressIndicator.setIndicatorColor(context.getColor(R.color.red));
              else progressIndicator.setIndicatorColor(context.getColor(progressColor));

                progressIndicator.setProgress(progress);
            setTextViewProgress(total,dailyNorm);
        }

        private void setTextViewProgress(double total, double dailyNorm)
        {
           if (textView!=null)
               textView.setText(String.format("%.1f",total)+"/"+
                    String.format("%.1f",dailyNorm)+" "+context.getString(R.string.gramm)
            );


        }



}
