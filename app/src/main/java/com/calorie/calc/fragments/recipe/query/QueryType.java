package com.calorie.calc.fragments.recipe.query;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.List;

public  interface QueryType {

          static void clear( List<QueryType> list)
          {
              for (QueryType item:
                      list) {
                  item.setInclude(false);
              }
          }
          static void clearAll()
          {
              clear(Arrays.asList(CuisineType.values()));
              clear(Arrays.asList(DishType.values()));
              clear(Arrays.asList(DietType.values()));
              clear(Arrays.asList(HealthType.values()));
              clear(Arrays.asList(MealType.values()));
              clear(Arrays.asList(EnergyType.values()));
          }


          String getQueryString();
          String getParametr();
          String getLable();
          String getDescription();
          boolean isIncluded();
          void setInclude(Boolean include);
          Button getTextViewButton();
          void  setButton(Button button);

          default Button getButton(Context context )
         {
          Button button = getTextViewButton();
          if (button!=null){
              button.setText( getLable());
              return button;}
          button = new Button(context);
          LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                  (LinearLayout.LayoutParams.WRAP_CONTENT,
                          85);

          params.setMargins(12,8,12,8);

          button.setLayoutParams(params);
          button.setText( getLable());
          button.setAllCaps(false);
          button.setTextSize(14);
          button.setTypeface(Typeface.SANS_SERIF);
          button.setTag(this);
          button.setTransformationMethod(null);
          button.setPadding(40,0,40,0);
          button.setIncludeFontPadding(false);
          button.setLineSpacing(-16,0);

          button.setSingleLine(true);
          button.setId(View.generateViewId());
        /*  button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            QueryType type = (QueryType)v.getTag();
            if(type.isIncluded())
            {
             setInclude(false);

            }
            else
            {
             setInclude(true);

            }
           }
          });*/
          setButton(button);
          setInclude(isIncluded());
          return button;
         }

}
