package com.calorie.calc;

import static com.calorie.calc.NavigationHelper.openMainFragment;
import static com.calorie.calc.NavigationHelper.showMainFragment;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.calorie.calc.databinding.ActivityMainBinding;
import com.calorie.calc.signup.RegistrationActivity;
import com.calorie.calc.utils.BackPressable;
import com.calorie.calc.utils.DisplaySize;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    public static final boolean DEBUG = !BuildConfig.BUILD_TYPE.equals("release");;
    ActivityMainBinding binding;
    static User user = new User();
     // поломался туулбар в регисрации
    //Если не выбрать время еды в добавлении вылетает ошибка, сделать дефолт какойто

    //на главной сделать нормально отображение названия/описания/калорий блюд
    //добавить фуутер
    //сделать норм подсчет калорий/бжу
    //обработать нажатие на стрелку свернуть
    // Отображение завтрака




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Caloriecalc);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setDisplaySize();
        openMainFragment(getSupportFragmentManager());



    /*    IngredientsApi apiInstance = new IngredientsApi();
        String query = burger; // String | The (natural language) search query.
        Integer number = 10; // Integer | The maximum number of items to return (between 1 and 100). Defaults to 10.
        Boolean metaInformation = false; // Boolean | Whether to return more meta information about the ingredients.
        String intolerances = egg; // String | A comma-separated list of intolerances. All recipes returned must not contain ingredients that are not suitable for people with the intolerances entered. See a full list of supported intolerances.
        try {
            List<InlineResponse20024> result = apiInstance.autocompleteIngredientSearch(query, number, metaInformation, intolerances);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IngredientsApi#autocompleteIngredientSearch");
            e.printStackTrace();
        }*/
      //  binding.bottomBar.setMenu();
     //   binding.bottomBar.getMenu().clear();
     //   binding.bottomBar.inflateMenu(R.menu.bottom_navigation);
//
        /* FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        FirebaseAuth.getInstance().signOut();
       if(firebaseAuth.getCurrentUser()==null)
         {
             Intent mIntent = new Intent(this, RegistrationActivity.class);
        startActivity(mIntent);
        }*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null)
                {
                    Intent mIntent = new Intent(getApplicationContext(), RegistrationActivity.class);
                    startActivity(mIntent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        final Fragment fragmentPanelSecond = getSupportFragmentManager()
                .findFragmentById(R.id.main_activ_second_container);
        if (fragmentPanelSecond instanceof BackPressable&&!fragmentPanelSecond.isHidden()) {
            {
              if( ! ((BackPressable) fragmentPanelSecond).onBackPressed())
                  showMainFragment(getSupportFragmentManager());
            }
            return;
        }


        final Fragment fragmentPanel = getSupportFragmentManager()
                .findFragmentById(R.id.main_activ_container);
        if (fragmentPanel instanceof BackPressable) {
            {
             if( ((BackPressable) fragmentPanel).onBackPressed())

                 return;
             else
             {
                 super.onBackPressed();
             }
            }
            return;
        }

        super.onBackPressed();
    }

    private void setDisplaySize() {

        Display display = this.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        DisplaySize.setHEIGHT(size.y);
        DisplaySize.setWIDTH(size.x);


    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MainActivity.user = user;
    }
}