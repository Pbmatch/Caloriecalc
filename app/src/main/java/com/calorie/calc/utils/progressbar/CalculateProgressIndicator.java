package com.calorie.calc.utils.progressbar;

public class CalculateProgressIndicator {
    public static int getProgress(double progress, double total)
    {
      Double d = 100/total*progress;
       return d.intValue();


    }
}


