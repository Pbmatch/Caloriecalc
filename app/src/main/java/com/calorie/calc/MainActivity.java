package com.calorie.calc;

import static com.calorie.calc.NavigationHelper.openMainFragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.calorie.calc.databinding.ActivityMainBinding;
import com.calorie.calc.edamam.network.RecipeRecipient;

public class MainActivity extends AppCompatActivity {


    public static final boolean DEBUG = !BuildConfig.BUILD_TYPE.equals("release");;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Caloriecalc);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        openMainFragment(getSupportFragmentManager());
        getDataFromServer();

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

      //  FirebaseAuth.getInstance().signOut();
       if(firebaseAuth.getCurrentUser()==null)
         {
             Intent mIntent = new Intent(this, RegistrationActivity.class);
        startActivity(mIntent);
        }*/
    }
    public void getDataFromServer() {

        RecipeRecipient recipient = new RecipeRecipient(this );
        recipient.getRecipe();
    }



}