package com.calorie.calc.utils.progressbar;

public class CalculateProgressIndicator {
    public static int getProgress(double progress, double total)
    {
      Double d = 100/total*progress;
      if(d>100)
          d=100.0;

       return d.intValue();


    }
}


